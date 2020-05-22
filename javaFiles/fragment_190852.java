public class ResponseSerializer extends JsonSerializer<Response> {
    @Override
    public void serialize(Response value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        Class<?> responseClass = value.getObject().getClass();
        JavaType responseJavaType = serializers.constructType(responseClass);
        gen.writeStartObject();
        gen.writeFieldName(serializers.findTypeSerializer(responseJavaType).getTypeIdResolver().idFromValue(value.getObject()));
        serializers.findValueSerializer(responseClass).serialize(value.getObject(), gen, serializers);
        /* Here you must manually serialize other properties */
        /* Like gen.writeStringField("property", value.getProperty()); */
        gen.writeEndObject();
    }
}