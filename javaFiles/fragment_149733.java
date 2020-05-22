private void setUpListViewIfNeeded() {
    if (poiListView == null) {
        poiListView = (ListView) findViewById(android.R.id.list);
    }
    if (poiListView != null) {

        Cursor data = poiDbhelper.getCursorOfAllEntries(true, null);
        if (data != null) {
            dataSource = new MapDataFileInstalledCursorAdapter(poiListViewContext, data, 0);
            poiListView.setAdapter(dataSource);             
        }
        showToastMessage(getString(R.string.toast_mesg_records_read) + " " + data.getCount());
    }
}