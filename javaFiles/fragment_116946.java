ArrayList<Item> items = new ArrayList<Item>();
JSONArray jsonArray = new JSONArray(out);
JSONObject jsonObject = new JSONObject();
Set<String> tempSet = new HashSet<String>();
for (int i = 0; i<jsonArray.length();i++){
    jsonObject = jsonArray.getJSONObject(i);
    if (!tempSet.contains(jsonObject.getString("titulo"))){
        items.add(new SectionItem(jsonObject.getString("titulo")));
        tempSet.add(jsonObject.getString("titulo"));
    }
    items.add(new EntryItem(jsonObject.getString("nombrelinea"), jsonObject.getString("monto")));
}