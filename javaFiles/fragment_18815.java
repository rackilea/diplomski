import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestBox.DefaultSuggestionDisplay;
import com.google.gwt.user.client.ui.SuggestBox.SuggestionCallback;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBoxBase;

public class PartialSuggestBox extends Composite {

    private static final char SUGGESTION_TRIGGER_CHAR = '@';

    private String startingText;
    private String endingText;
    private boolean showSuggestions;

    private MultiWordSuggestOracle oracle;
    private TextBoxBase box;
    private SuggestBox suggestBox;

    public PartialSuggestBox() {

        ArrayList<String> suggestionList = new ArrayList<String>();
        suggestionList.add("Adam");
        suggestionList.add("Chris");
        suggestionList.add("John");
        suggestionList.add("Joe");
        suggestionList.add("Jane");
        suggestionList.add("Bob");

        oracle = new MultiWordSuggestOracle() {
            @Override
            public void requestSuggestions(Request request, Callback callback) {
                if(showSuggestions) {
                    // the original query contains all text from the TextBox
                    // so we need to remove the unnecessary parts
                    // leave just the part entered after showing suggestions
                    String query = request.getQuery();
                    query = query.substring(startingText.length(), query.length() - endingText.length());

                    // there are two different methods for empty and non-empty query
                    if(query.isEmpty()) {
                        request.setQuery(null);
                        super.requestDefaultSuggestions(request, callback);
                    }
                    else {
                        request.setQuery(query);
                        super.requestSuggestions(request, callback);
                    }
                }
            }
        };

        // set suggestion list for empty query
        oracle.setDefaultSuggestionsFromText(suggestionList);
        // set suggestion list for non-empty query
        oracle.addAll(suggestionList);

        DefaultSuggestionDisplay display = new DefaultSuggestionDisplay() {
            @Override
            protected void showSuggestions(SuggestBox suggestBox, Collection<? extends Suggestion> suggestions, boolean isDisplayStringHTML, boolean isAutoSelectEnabled, SuggestionCallback callback) {
                // override showSuggestions to be able to suppress it 
                if(showSuggestions)
                    super.showSuggestions(suggestBox, suggestions, isDisplayStringHTML, isAutoSelectEnabled, callback);
            }

            @Override
            public void hideSuggestions() {
                // when suggestions are hidden we again start to suppress them
                super.hideSuggestions();
                showSuggestions = false;
            }
        };

        box = new TextArea();
        // box = new TextBox(); // you can use TextArea or TextBox
        box.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if(event.getCharCode() == SUGGESTION_TRIGGER_CHAR) {
                    // run deferred to let the TextBox consume the new char
                    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                        @Override
                        public void execute() {
                            // get the text parts existing in the TextBox
                            // we will need to remove them for new suggestions
                            int cursorPosition = box.getCursorPos();
                            startingText = box.getText().substring(0, cursorPosition);
                            endingText = box.getText().substring(cursorPosition);

                            // now we stop to suppress showing suggestions
                            showSuggestions = true;
                            suggestBox.showSuggestionList();
                        }
                    });
                }
            }
        });

        // put it all together
        suggestBox = new SuggestBox(oracle, box, display);
        suggestBox.addSelectionHandler(new SelectionHandler<Suggestion>() {
            @Override
            public void onSelection(SelectionEvent<Suggestion> event) {
                // when selection is made we need to combine previously entered text with selected one
                box.setText(startingText + box.getText() + endingText);
                // set cursor position at the end of selected text
                box.setCursorPos(startingText.length() + event.getSelectedItem().getReplacementString().length());
            }
        });

        initWidget(suggestBox);
    }
}