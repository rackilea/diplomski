ArrayList<HashMap<String, String>> detailss = new ArrayList<HashMap<String, String>>();
ItemList=(ListView) findViewById(R.id.listViewItems);

HashMap<String, String> map = new HashMap<String, String>();

    map.put("itemId", "1");
    map.put("itemName", "Name");
    map.put("itemPrice", "120");

    detailss.add(map);

    adapter = new CustomItemsList(this, detailss);
    ItemList.setAdapter(adapter);