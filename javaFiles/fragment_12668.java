public static class ClassNameSerializer extends JsonSerializer<Class> {
    @Override
    public void serialize(Class value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeFieldName(value.getCanonicalName());
    }
}