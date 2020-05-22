String jsonAsString = "/*Your json as a String*/";
JsonArray jsonArray = new JSONArray(jsonAsString);

for(int i=0; i<jsonArray.length(); i++) {
    JSONObject jsonObject = jsonArray.getJSONObject(i);
    //Get values from your jsonObject
    jsonObject.has("extra"); //Check if extra is present
}