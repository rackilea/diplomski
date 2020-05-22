class MySerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {

        gen.writeString("not_defined");
    }
}