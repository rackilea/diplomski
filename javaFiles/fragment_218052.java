List<User> userList = new ArrayList<>();
EasyDB easyDB = EasyDB.init(this, DATABASE_NAME).setTableName(TABLE_NAME);
Cursor res = easyDB.getAllData();

if(res != null && res.getCount() > 0) {
    res.moveToFirst();
    do {
        int id = res.getInt(0);
        String name = res.getString(1);
        String pass = res.getString(2);
        userList.add(new User(id, name, pass));

    } while (res.moveToNext());
}
res.close();

RecyclerView recyclerView = findViewById(R.id.recycler_view);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
UsersRecyclerAdapater adapter = new UsersRecyclerAdapater(this, userList);
recyclerView.setAdapter(adapter);