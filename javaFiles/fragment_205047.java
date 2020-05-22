JSONArray mJsonArray = new JSONArray(jsonStr);
    JSONObject mJsonObject = mJsonArray.getJSONObject(0);

    String pmid = mJsonObject.getString("pmid");
    String name = mJsonObject.getString("name");
    String result = mJsonObject.getString("result");


    JSONArray mJsonArrayProperty = mJsonObject.getJSONArray("properties");
    for (int i = 0; i < mJsonArrayProperty.length(); i++) {
        JSONObject mJsonObjectProperty = mJsonArrayProperty.getJSONObject(i);

        String prop_id = mJsonObjectProperty.getString("prop_id");
        String prop_name = mJsonObjectProperty.getString("prop_name");
        String address = mJsonObjectProperty.getString("address");
        String city = mJsonObjectProperty.getString("city");
        String state = mJsonObjectProperty.getString("state");
        String zip = mJsonObjectProperty.getString("zip");
        String lat = mJsonObjectProperty.getString("lat");
        String lon = mJsonObjectProperty.getString("long");
    }