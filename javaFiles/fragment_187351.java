private int getPosition(JSONArray jsonArray) throws JSONException {
        for(int index = 0; index < jsonArray.length(); index++) {
            JSONObject jsonObject = jsonArray.getJSONObject(index);
            if(jsonObject.getString("name").equals("apple")) {
                return index; //this is the index of the JSONObject you want
            } 
        }
        return -1; //it wasn't found at all
    }