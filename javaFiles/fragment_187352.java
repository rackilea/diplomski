private JSONObject getPosition(JSONArray jsonArray) throws JSONException {
        for(int index = 0; index < jsonArray.length(); index++) {
            JSONObject jsonObject = jsonArray.getJSONObject(index);
            if(jsonObject.getString("name").equals("apple")) {
                return jsonObject; //this is the index of the JSONObject you want
            } 
        }
        return null; //it wasn't found at all
    }