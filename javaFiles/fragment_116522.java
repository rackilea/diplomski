public class SomeClassSerializer extends JsonSerializer<SomeClass>
{
    @Override
    public void serialize(SomeClass sc, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        gen.writeStartObject();
        // write id propertry
        gen.writeStringField("id", sc.getId());   
        // loop on keyValue entries, write each as property
        for (Map.Entry<String, Object> keyValueEntry : sc.getKeyValue().entrySet()) {
            gen.writeObjectField(keyValueEntry.getKey(), keyValueEntry.getValue());
        }
        gen.writeEndObject();
    }
}