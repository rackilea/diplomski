boolean containsKey(JSONObject myJsonObject, String key) {
    boolean containsHelloKey = false;
    try {
        JSONArray arr = myJsonObject.getJSONArray("jArray");
        for(int i=0; i<arr.length(); ++i) {
            if(arr.getJSONObject(i).get(key) != null) {
               containsHelloKey = true;
               break;
            }
        }
    } catch (JSONException e) {}

    return containsHelloKey;
}