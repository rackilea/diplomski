public void saveOrderedCollection(Collection collection, String key){
    JSONArray jsonArray = new JSONArray(collection);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(key, jsonArray.toString());
    editor.commit();
}

public Collection loadOrderedCollection(String key){
    ArrayList arrayList = new ArrayList;
    SharedPreferences.Editor editor = sharedPreferences.edit();
    JSONArray jsonArray = new JSONArray(editor.getString(key, "[]"));
    for (int i = 0; i < jsonArray.length(); i++) {
        arrayList.put(jsonArray.get(i));
    }
    return arrayList;
}