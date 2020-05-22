JSONArray jsonArray = new JSONArray(jsonString);
for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject jsonObject = jsonArray.getJSONObject(i);
    JSONObject postObj = jsonObject.getJSONObject("post");
    for (String i : postObj.keys()) {
         System.out.println("Key: " + i + "; Value: " + postObj.getString(i));
    }
}