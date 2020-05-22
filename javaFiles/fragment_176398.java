public void populateListView() {
    busList = new String[2];
    busList[0] = "test";
    busList[1] = "test1";

    // build adapter
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dat_item, busList);

    // config the list view
    ListView list = (ListView) findViewById(R.id.listView5);
    list.setAdapter(adapter);
}