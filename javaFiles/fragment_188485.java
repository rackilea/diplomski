class JacksonSerializer extends StdSerializer{
    protected BSJacksonSerializer(Class t) {
        super(t)
    }

    @Override
    void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeStartObject()

            jsonGenerator.writeStringField("test","test")
            jsonGenerator.writeEndObject()
    }
}