JsonObject object = Json.parse(output).asObject();
JsonArray results = object.get("results").asArray();
for (JsonValue item : results) {
  String date = item.asObject().getString("date", "");
  String id = item.asObject().getString("id", "");
  ...  
}