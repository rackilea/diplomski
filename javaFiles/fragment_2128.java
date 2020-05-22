class MySerializerAndDeserializer implements JsonSerializer<Object>, JsonDeserializer<Object>{

public JsonElement serialize(Object src, Type typeOfSrc,
        JsonSerializationContext context) {
    Class clazz = src.getClass();
    JsonElement serialize = context.serialize(src);
    JsonArray array = new JsonArray();
    array.add(new JsonPrimitive(clazz.getName()));
    array.add(serialize);
    return array;
}

public Object deserialize(JsonElement json, Type typeOfT,
        JsonDeserializationContext context) throws JsonParseException {
    JsonArray array = json.getAsJsonArray();
    String asString = array.get(0).getAsString();
    Object deserialize = null;
    try {
        deserialize = context.deserialize(array.get(1).getAsJsonObject(), Class.forName(asString));
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return deserialize;
}
}