MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
oracle.add("one");
oracle.add("two");
oracle.add("three");

TextBox box = new TextBox();
final DefaultSuggestionDisplay display = new DefaultSuggestionDisplay();

SuggestBox suggestBox = new SuggestBox(oracle, box, display);

Window.addWindowScrollHandler(new ScrollHandler() {
    @Override
    public void onWindowScroll(ScrollEvent event) {
        display.hideSuggestions();
    }
});