public void serialize(ObjectType obj, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
    gen.writeStartObject();
    // write other elements
    String someValue = obj.getSomeValue();
    if (someValue == null) {
        someValue = "";
    }
    gen.writeStringField("some-value", someValue);
    gen.writeEndObject();
}