class CustomDeserializer extends JsonSerializer<String>{

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        gen.writeStartArray();
        gen.writeString(value);
        gen.writeEndArray();
    }
}