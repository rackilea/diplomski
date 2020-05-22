private static void modifyObject(JsonObject obj, JsonObject replacement) {
    obj.remove("value");
    for (String key : replacement.keySet()) {
        obj.addProperty(key, replacement.get(key).getAsString());
    }
}

public static JsonElement traverse(JsonElement element, JsonObject allReplacements) {
    if (element.isJsonObject()) {
        JsonObject asJsonObject = element.getAsJsonObject();
        ///keys can change after we modify object,
        //but we want to iterate only over original keys
        Set<String> originalKeys = new HashSet<>(asJsonObject.keySet());
        for (String key : originalKeys) {
            if (key.equals("value")) {
                String value = asJsonObject.get(key).getAsString();
                modifyObject(asJsonObject, allReplacements.getAsJsonObject(value));
            } else {
                traverse(asJsonObject.get(key), allReplacements);
            }
        }
    } else if (element.isJsonArray()) {
        for (JsonElement innerElement : element.getAsJsonArray()) {
            traverse(innerElement, allReplacements);
        }
    }
    return element;
}