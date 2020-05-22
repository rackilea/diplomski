final JsonParser parser = new JsonParser();
final JsonElement jsonElement = parser.parse(new FileReader("/path/to/myfile"));
final JsonObject jsonObject = jsonElement.getAsJsonObject();

for (final Entry<String, JsonElement> entry : jsonObject.entrySet()) {
   final String key = entry.getKey();
   final JsonElement value = entry.getValue();
   ....
}