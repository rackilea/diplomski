@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.second, menu);
    SearchView searchView =
    (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setIconified(false);
        return super.onCreateOptionsMenu(menu);
    }