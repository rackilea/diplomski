/**
 * Refresh the list with the items in the Mobile Service Table
 */
private void refreshItemsFromTable() {

    // Get the items that weren't marked as completed and add them in the
    // adapter

    Log.d(TAG, "refreshItemsFromTable");
    mToDoTable.execute(new TableQueryCallback<MapObjects_FromAzure>() {

        public void onCompleted(List<MapObjects_FromAzure> result, int count,
                Exception exception, ServiceFilterResponse response) {
            if (exception == null) {

                Log.d(TAG,
                        "refreshItemsFromTable on complete, with no exception thrown so far. ");

                mAdapter.clear();

                for (MapObjects_FromAzure item : result) {
                    mAdapter.add(item);

                }

            } else {
                createAndShowDialog(exception,
                        "Error" + exception.toString());
            }
        }
    });