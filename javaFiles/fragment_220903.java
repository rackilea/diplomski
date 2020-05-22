public class ObjectDeserializer implements JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        String value = element.getAsString();
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return value;
        }
    }

}