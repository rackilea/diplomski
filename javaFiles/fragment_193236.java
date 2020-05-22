new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
        mListView.clearTextFilter();
    } else {
        mListView.setFilterText(newText.toString()); //you can use this to filter items
    }
    return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }
}