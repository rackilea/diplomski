JSONArray root = (JSONArray) JSONValue.parseWithException(json);
JSONObject rootObj = (JSONObject) root.get(0);
JSONArray array = (JSONArray) rootObj.get("friends");

for (int i = 0; i < array.size(); i++) {
    JSONObject cap = (JSONObject) array.get(i);
    String first = (String) cap.get("name");
    System.out.println(first);
}