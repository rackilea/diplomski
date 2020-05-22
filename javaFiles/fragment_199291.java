clearButton.setOnClickListener(v -> {
    if(searchView.getQuery().length() == 0) {
        searchView.setIconified(true);
    } else {
        searchView.setQuery("", false);
    }
});