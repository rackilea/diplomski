ArrayList<String> COUNTRIES = new ArrayList<>();
public void refreshView() {

    MyDatabase database = new MyDatabase(ViewList.this);

    Cursor cursor = database.fetchAllData();

    COUNTRIES.clear();
    while (cursor.moveToNext()) {
        String temp = cursor.getString(cursor.getColumnIndex(database.COL1));
        COUNTRIES.add(temp);
    }
    arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
    ListView listView = (ListView) findViewById(R.id.list);
    listView.setAdapter(arrayAdapter);

}