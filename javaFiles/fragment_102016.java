public void parseStoredData(){
    SharedPreferences pref = this.getPreferences(MODE_PRIVATE);
    String storedCollection = pref.getString("Categories", null);
    //Parse the string to populate your collection.
    ArrayList<HashMap<String, Object>> collection = new ArrayList<HashMap<String, Object>>();
    if (storedCollection != null) {
        try {

            JSONArray array = new JSONArray(storedCollection);

            for (int i = 0; i < array.length(); i++) {
                try {

                    JSONObject object = array.getJSONObject(i);
                    HashMap<String,Object> item = new HashMap<String, Object>();
                    Iterator<String> it = object.keys();

                    while (it.hasNext()) {
                        String key = it.next();
                        item.put(key, object.get(key));
                    }

                    collection.add(item);
                } catch (JSONException e) {
                        e.printStackTrace();
                }

            }

        } catch (JSONException e) {
            Log.e("JSON", "while parsing", e);
        }
    }
}