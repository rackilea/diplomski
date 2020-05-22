public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.mnuEnableSomething:
            {
                refreshTheWholeUi();
                return true;
            }
        case R.id.mnuClearList:
            {
                refreshTheWholeUi();
                return true;
            }
    }
}

public void onResume() {
    super.onResume();
    refreshTheWholeUi();
}