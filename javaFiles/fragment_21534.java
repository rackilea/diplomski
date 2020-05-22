class JacksonListSerializer extends JsonSerializer<JacksonList<?>> {

    @Override
    public void serialize(JacksonList<?> list, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeStartArray();
        if (list != null) {
            for (Object item : list) {
                generator.writeObject(item);
            }
        }
        generator.writeEndArray();
    }
}