String json = "[{\"field_type\":\"descriptive\"},"
            + "{\"field_type\":\"test1\"},"
            + "{\"field_type\":\"descriptive\"}"
            + "{\"field_type\":\"test2\"}"
            + "]";

    HashSet<JSONArray> arrayStore = new HashSet<JSONArray>();
    JSONArray store = new JSONArray();
    JSONArray arr = new JSONArray(json);
    for(int i =0; i < arr.length(); i++){
        JSONObject obj = arr.getJSONObject(i);
        if("descriptive".equals(obj.getString("field_type"))){
            store = new JSONArray(); // create a new array for each section...
            arrayStore.add(store); //store the current object
        } else {
            store.put(obj); //store the object in the array
        }
    }