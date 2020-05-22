public static class JavaxJsonValConverter
        implements JsonSerializer<JsonValue> {

    @Override
    public JsonElement serialize(final JsonValue jsonValue, final Type type, final JsonSerializationContext context) {
        return new JsonParser().parse(jsonValue.toString());
    }

}