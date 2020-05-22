//...
    String[] NAMES = getResources().getStringArray(R.array.names_array);
    // construct the list of model object for your rows:
    ArrayList<Model> items = new ArrayList<Model>();
    for (int i = 0; i < 20; i++) {
        items.add(new Model(NAMES[i], 0));// I guess the counter starts at 0
    }
    mAdapter = new ModelAdapter(this, R.layout.list_item, R.id.name, items);
    setListAdapter();
    ListView lv = getListView();
    lv.setTextFilterEnabled(true);      

//...