JSONObject jo = new JSONObject(jsonString); //
JSONArray ja = jo.getJSONArray("id_list"); // get the JSONArray
List<String> keys = new ArrayList<>();

for(int i=0;i<ja.length();i++){
    keys.add(ja.getString(i)); // iterate the JSONArray and extract the keys
}

return keys; // return the list