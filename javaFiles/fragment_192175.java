JsonElement jsonElement = parser.parse(html.toString()).getAsJsonObject();
JsonObject rootObj = jsonElement.getAsJsonObject();
JsonArray documents = (JsonArray) rootObj.get("documents");
Iterator < JsonElement > itr = documents.iterator();
while (itr.hasNext()) {
 JsonObject jsonObject = (JsonObject) itr.next();
 double x = jsonObject.getDouble("x");
 double y = jsonObject.getDouble("y");
}