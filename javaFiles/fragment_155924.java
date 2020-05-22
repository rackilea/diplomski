public final class UnifiedJsonSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object object, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        if (object instanceof Entry) {
            // Entry serialization code
        } else if (object instanceof Map) {
            // Map serialization code
        } else  {
            // default serialization code
        }
}