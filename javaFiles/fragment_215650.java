JSONArray array = obj.getJSONArray("social");
for (int i = 0; i < array.length(); i++) {
    JSONObject row = array.getJSONObject(i);
    id = row.getInt("id");
    message= row.getString("message");
}