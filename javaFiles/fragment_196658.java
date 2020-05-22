private void simpleAdapterListView()
{


    String[] titleArr = { "1", "2", "3", "4","5"};
    String[] descArr = { "A", "B", "C", "D", "E" };

    ArrayList<Map<String,Object>> itemDataList = new ArrayList<Map<String,Object>>();;

    int titleLen = titleArr.length;
    for(int i =0; i < titleLen; i++) {
        Map<String,Object> listItemMap = new HashMap<String,Object>();
        listItemMap.put("title", titleArr[i]);
        listItemMap.put("description", descArr[i]);
        itemDataList.add(listItemMap);
    }

    SimpleAdapter simpleAdapter = new SimpleAdapter(this,itemDataList,android.R.layout.simple_list_item_2,
            new String[]{"title","description"},new int[]{android.R.id.text1,android.R.id.text2});

    ListView listView = (ListView)findViewById(R.id.listViewExample);
    listView.setAdapter(simpleAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
            Object clickItemObj = adapterView.getAdapter().getItem(index);
            Toast.makeText(ListViewActivity.this, "You clicked " + clickItemObj.toString(), Toast.LENGTH_SHORT).show();
        }
    });

}