@Override
public boolean onPrepareOptionsMenu(Menu menu) {

    menu.clear();
    switch ((int) _viewPager.getCurrentItem()) {
        case 0:
            getSupportMenuInflater().inflate(R.menu.empty_menu, menu);
            break;
        case 1:
            getSupportMenuInflater().inflate(R.menu.action_bar_menu, menu);
            MenuItem searchItem = menu.findItem(R.id.search);
            SearchView searchView = (SearchView) searchItem.getActionView();
            searchView.setSubmitButtonEnabled(true);
            searchView.setOnQueryTextListener(queryTextListener);
            break;
        case 2:
            getSupportMenuInflater().inflate(R.menu.empty_menu, menu);
            break;
    }
    return super.onPrepareOptionsMenu(menu);
}