panel.addDomHandler(new ScrollHandler() {
    @Override
    public void onScroll(ScrollEvent event) {
        ((DefaultSuggestionDisplay) suggestBox.getSuggestionDisplay()).hideSuggestions();
    }
}, ScrollEvent.getType());