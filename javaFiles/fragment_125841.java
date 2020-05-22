public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.mnuEnableSomething:
            {
                enableIt();
                return true;
            }
        case R.id.mnuClearList:
            {
                justClearTheList();
                return true;
            }
    }
}

public void onResume() {
    super.onResume();
    refreshTheWholeUi();
}