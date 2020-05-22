JSONArray array = new JSONArray(responseString);

for(int i = 0; i < array.length(); i++){
  JSONObject item = array.get(i);
  String name = item.get("name");
  String email = item.get("email");
  // ... You get the Idea.
}