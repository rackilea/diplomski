class CustomJsonDeserializer<T> implements JsonDeserializer<Body<T>> {

    private final Class<T> clazz;

    public CustomJsonDeserializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Body<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject body = json.getAsJsonObject().getAsJsonObject("body");
        JsonArray arr = body.entrySet().iterator().next().getValue().getAsJsonArray();
        List<T> list = new ArrayList<>();
        for(JsonElement element : arr) {
            JsonElement innerElement = element.getAsJsonObject().entrySet().iterator().next().getValue();
            list.add(context.deserialize(innerElement, clazz));
        }
        return new Body<>(list);
    }
}