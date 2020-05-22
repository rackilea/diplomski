static class CustomSerializer extends JsonSerializer{

    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeArrayFieldStart("inputFields");

        Field[] fields = value.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                jgen.writeStartObject();
                jgen.writeObjectField("name", field.getName());
                jgen.writeObjectField("value", field.get(value));
                jgen.writeEndObject();
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        jgen.writeEndArray();
        jgen.writeEndObject();
    }
}