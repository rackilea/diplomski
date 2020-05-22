JSONObject json = readurl("https://graph.facebook.com/pageid");
JSONArray dataJsonArray = json.getJSONArray("data");
for(int i=0; i<dataJsonArray.length; i++) {
   JSONObject dataObj = dataJsonArray.get(i);
   String id = dataObj.getString("id");
   //Similarly you can extract for other fields.
}