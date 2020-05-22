JSONObject json = new JSONObject(str);
Iterator<String> keyIterator = json.keys();
while (keyIterator.hasNext()) {
  JSONObject actor = json.getJSONObject(keyIterator.next());
  String user_name = actor.getString("user_name");
  allNames.add(user_name);
}