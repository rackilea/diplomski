import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

public class AutoShowComboBoxTableCell<S, T> extends ComboBoxTableCell<S, T> {

    /* 
     * May want to provide alternate constructors and static methods similar to
     * the ComboBoxTableCell class (i.e. the superclass).
     */

    private boolean enterPressed;

    public AutoShowComboBoxTableCell(StringConverter<T> converter, ObservableList<T> values) {
        super(converter, values);
        getStyleClass().add("auto-show-combo-box-table-cell");

        // Assumes TableView property is set only once (valid assumption?)
        tableViewProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                // Need to know if editing was started by the user pressing
                // the ENTER key (see #startEdit())
                EventHandler<KeyEvent> filter = event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        enterPressed = event.getEventType() == KeyEvent.KEY_PRESSED;
                    }
                };
                // Possible memory leak? Consider using WeakEventHandler (read docs)
                getTableView().addEventFilter(KeyEvent.KEY_PRESSED, filter);
                getTableView().addEventFilter(KeyEvent.KEY_RELEASED, filter);
                observable.removeListener(this);
            }
        });
    }

    @Override
    public void startEdit() {
        if (isEditing()) return;

        super.startEdit();
        if (isEditing()) {
            if (enterPressed) {
                // Cell was put into edit mode by the user pressing ENTER. This causes
                // problems since *releasing* ENTER while the ComboBox has the focus
                // results in the value being committed; this leads to the current value
                // being committed *immediately* after entering edit mode—not what we want. 
                // To fix that we consume the first ENTER-released event and then let all
                // subsequent events through (by removing the event filter).
                addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<>() {
                    @Override public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            event.consume();
                            removeEventFilter(KeyEvent.KEY_RELEASED, this);
                        }
                    }
                });
            }
            ComboBox<?> comboBox = (ComboBox<?>) getGraphic();
            comboBox.requestFocus(); // Needed to allow releasing ENTER to commit the value
            comboBox.show();
        }
    }

    @Override
    public void cancelEdit() {
        if (isEditing()) {
            super.cancelEdit();
            requestTableViewFocus();
        }
    }

    @Override
    public void commitEdit(T newValue) {
        if (isEditing()) {
            super.commitEdit(newValue);
            requestTableViewFocus();
        }
    }

    // Allows user to keep navigating the table via the keyboard
    private void requestTableViewFocus() {
        TableView<S> tableView = getTableView();
        if (tableView != null) {
            tableView.requestFocus();
        }
    }

}