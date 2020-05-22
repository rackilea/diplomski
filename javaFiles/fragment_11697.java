public class DTOSerializer extends JsonSerializer<DTO>
{
    @Override
    public void serialize(DTO value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        gen.writeStartObject();
        gen.writeFieldName("fields");
        gen.writeStartArray();
        Field[] fields = dto.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonName.class)) {
                Object fieldValue = null;
                try {
                    fieldValue = field.get(dto);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
                if (fieldValue != null) {
                    String fieldName = ((JsonName)field.getAnnotation(JsonName.class)).value();
                    gen.writeStartObject();
                    gen.writeStringField("name", fieldName);
                    gen.writeObjectField("values", fieldValue);
                    gen.writeEndObject();
                }
            }
        }

        gen.writeEndArray();
        gen.writeEndObject();
    }
}