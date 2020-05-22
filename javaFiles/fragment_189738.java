JSONArray jsonArr = new JSONArray(getVersionJson);

for (int i = 0; i < jsonArr.length(); i++) {
    JSONObject jsonObj = jsonArr.getJSONObject(i);
    //Now you can fetch values from each JSON Object
}