ArrayList<String> items = new ArrayList<String>();
for(int i=0; i < jArray.length() ; i++) {
    json_data = jArray.getJSONObject(i);
    int id=json_data.getInt("id");
    String name=json_data.getString("name");
    items.add(name);
    Log.d(name,"Output");
}

ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this,  
           android.R.layout.simple_expandable_list_item_1, items));
setListAdapter(mArrayAdapter)