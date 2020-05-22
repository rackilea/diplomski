String yourJson = "{your json here}";
JsonParser parser = new JsonParser();
JsonElement element = parser.parse(yourJson);
JsonObject obj = element.getAsJsonObject(); //since you know it's a JsonObject
Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
for (Map.Entry<String, JsonElement> entry: entries) {
    System.out.println(entry.getKey());
}