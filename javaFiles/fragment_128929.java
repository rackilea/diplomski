...

    databaseHelper.insertData(getIntent().getExtras().getString("tag_person_name"));
/* This line is moved from below to this place i.e before you use the changeCursor method on it*/
    customAdapter = new CustomCursorAdapter(ListActivity.this, databaseHelper.getAllData()); 
customAdapter.changeCursor(databaseHelper.getAllData());
    listView.setOnItemClickListener(listContentOnItemClickListener);

    ...