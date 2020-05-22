public void getJsonData(JSONArray ja) {
 **List<String> arrNames = new ArrayList<String>**;
 try {
    // JSONArray jArray = new JSONArray(result);
    for (int i = 0; i < ja.length(); ++i) {
        JSONObject jo = ja.getJSONObject(i);
        **arrNames[i] = jo.names(i);**
        Log.i("Connect->getJsonData", jo.getString("tableno"));
    }
 } catch (Exception e) {
    Log.e("ConnectToDatabase->getJsonData", "Error Parsing JSON Data "
            + e.toString());
 }
}