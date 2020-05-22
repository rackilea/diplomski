HashMap<String, String> map = new HashMap<String, String>();

map.put(FOODID3, itemID);
map.put(FOODNAME3, itemValue);  


/*for (Map.Entry<String, String> entry : map.entrySet())
{
    String key = entry.getKey();
    String value = entry.getValue();
}*/

LIST3.add(map);

LISTORDER = (ListView) findViewById(R.id.listOrder);

List3Adapter adapter = new List3Adapter(MainActivity.this, LIST3);
LISTORDER.setAdapter(adapter);

/*adapter.setNotifyOnChange(true);
adapter.addAll(map);
adapter.notifyDataSetChanged();*/