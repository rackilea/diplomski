GridView oWordGrid = (GridView) findViewById(R.id.myGrid);
ArrayList<Object> oArrayList = new ArrayList<Object>();
oArrayList.add("abc");
oArrayList.add("def");
oArrayList.add("blah");
ListAdapter myAdapter = new MyAdapter(this, R.layout.word_item, oArrayList);
oWordGrid.setAdapter(myAdapter);