JSONArray jsonArray = new JSONArray(responseString);
int i = 0;
while (i <jsonArray.length()) {
    JSONObject jsonObj = jsonArray.getJSONObject(i);
    String name = jsonObj.getString("name");
    String description = jsonObj.getString("desc");
    //TODO create your Java object and store these strings into it.
    i++;
}