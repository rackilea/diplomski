for (int i = 0; i < jsonArray.length(); i++) {
 JSONObject jsonObject = jsonArray.getJSONObject(i);
 String name = jsonObject.optString("name","defaultValue");
 String content = jsonObject.optString("content","defaultValue");
 String published = jsonObject.optString("published","defaultValue");
 list.add(new CommentsLibrary(name, content, published));
 }