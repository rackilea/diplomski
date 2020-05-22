listView = (ListView) findViewById(R.id.myListView);
ArrayList<MyItem> myItems = new ArrayList<>();

for (int i = 0; i < 5; i++) {
    MyItem myItem = new MyItem();
    myItem.setName("Name_" + i);
    myItem.setSomething("RM_" + i);
    myItems.add(myItem);
}

MyAdapter myAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1, myItems);
listView.setAdapter(myAdapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyItem myItem = (MyItem)listView.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), ""+myItem.getName(), Toast.LENGTH_SHORT).show();
    }
});