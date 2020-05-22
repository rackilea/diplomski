if (json.startsWith("[")) {
    // We have a JSONArray
    try {
        jObj = new JSONObject();
        jObj.put("data", new JSONArray(json));
    } catch (JSONException e) {
        Log.d("JSON Parser", "Error parsing JSONArray " + e.toString());
    }
    return jObj;
}