final DroidGap droidGap = this;
final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
    public boolean onQueryTextChange(String newText) {
        droidGap.loadUrl(...);
        return true;
    }