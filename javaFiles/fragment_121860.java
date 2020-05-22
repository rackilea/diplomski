SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
        .getActionView();    

SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
    public boolean onQueryTextChange(String newText) {
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        search = query;
    }
};
searchView.setOnQueryTextListener(queryTextListener);