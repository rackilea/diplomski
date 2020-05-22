public class PropertyValueSerializer extends JsonSerializer<PROPERTY_VALUE> {

    @Override
    public void serialize(PROPERTY_VALUE property_value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(property_value.getKey());
        jsonGenerator.writeString(property_value.getValue());
        jsonGenerator.writeEndObject();
    }
}