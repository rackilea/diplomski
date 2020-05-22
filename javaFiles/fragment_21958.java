public static JsonElement fromString(String json, String path)
        throws JsonSyntaxException {
    JsonObject obj = new GsonBuilder().create().fromJson(json, JsonObject.class);
    String[] seg = path.split("\\.");
    for (String element : seg) {
        if (obj != null) {
            JsonElement ele = obj.get(element);
            if (!ele.isJsonObject()) 
                return ele;
            else
                obj = ele.getAsJsonObject();
        } else {
            return null;
        }
    }
    return obj;
}