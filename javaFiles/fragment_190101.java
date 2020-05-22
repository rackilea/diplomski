private CustomAdapter customAdapter;
//...
customAdapter = new CustomAdapter(this);
ListView listView = (ListView) findViewById(R.id.main_list_view);
    listView.setAdapter(customAdapter);
    customAdapter.loadObjects();