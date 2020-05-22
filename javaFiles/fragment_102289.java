ArrayList<Plate> FullMenu;
    FullMenu = mydb.getPlates("Entrees");
    Plate p;
    int i;
    MyClassAdapter adapter = new MyClassAdapter(this,0,FullMenu);
    ListView listView = (ListView) findViewById(R.id.list);
    for (i=0; i < FullMenu.size(); i++) {
        p = FullMenu.get(i);
        adapter.add(p);
    }
    listView.setAdapter(adapter);