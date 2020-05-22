//Create a rows adapter for your fragment
ArrayObjectAdapter mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
setAdapter(mRowsAdapter);

//Create a row and populate it
ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(someItemPresenter);
listRowAdapter.setItems(someItems, someDiffCallback);
ListRow row = new ListRow(listRowAdapter);

//Add row
mRowsAdapter.add(row);