ArrayList<MyListData> arrayListData = new ArrayList<MyListData>();
    MyListDataAdapter adapter = new MyListDataAdapter(this, arrayListData);

    for (MyListData g : result) {
        adapter.add(g);
    }
    mLstMy.setAdapter(adapter);