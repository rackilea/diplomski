public JsonElement serialize(Message src, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject elem = new JsonObject();

    if (src == null) {

    } else {
        elem.addProperty("type", src.getClass().getSimpleName());
        elem.addProperty("attribute", src.getTheMessage());
        elem.add("data", src.anotherMessage != null ? context.serialize(src.anotherMessage, Message.class): null);
    }

    return elem;
}