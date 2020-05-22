JSONArray jsonPersonData = new JSONArray(sb);
for (int i = 0; i < jsonPersonData.length(); i++) {
    JSONObject item = jsonPersonData.getJSONObject(i);
    String name = item.getString("name");
    String surname = item.getString("price");
}