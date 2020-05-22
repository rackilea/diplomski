JSONArray jsonarray = new JSONArray(json.getString("response"));
Log.e("Hello","Hi"+jsonarray);
for (int i = 0; i < jsonarray.length(); i++) {
    JSONObject jsonObjectmain = jsonarray .getJSONObject(i);
    JSONArray array = jsonObjectmain.getJSONArray("updates");
    for (int j = 0; j < array.length(); j++) {
         JSONObject jsonObject = array.getJSONObject(j);
         String id = jsonObject.getString("id").toString();
         String name = jsonObject.getString("name").toString();
         String photo = jsonObject.getString("photo").toString();
         String updates = jsonObject.getString("updates").toString();

    }      
}