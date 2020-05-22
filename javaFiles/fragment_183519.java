JSONArray array = (JSONArray) ((JSONObject) object.get("data"))
                .get("children");
JSONObject data;
for (int i = 0; i < array.size(); i++) {
     data = (JSONObject) array.get(i);
}