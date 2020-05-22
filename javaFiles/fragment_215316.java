final Iterable<Entry<String, Integer>> iterable = getIterable();
final Gson gson = new Gson();
final JsonArray jsonArray = new JsonArray();

for (final Entry<String, Integer> entry : iterable) {
    final JsonElement jsonElement = gson.toJsonTree(entry);
    jsonElement.getAsJsonObject().remove("hash");
    jsonArray.add(jsonElement);
}