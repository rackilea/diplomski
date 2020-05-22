public class MapToCoupleArraySerializer extends JsonSerializer<Map<?, ?>>{

    @Override
    public void serialize(Map<?, ?> value, JsonGenerator generator,
            SerializerProvider serializers) throws IOException,
            JsonProcessingException {
        generator.writeStartArray();
        for (Entry<?, ?> entry : value.entrySet()){
            generator.writeStartObject();
            generator.writeObjectField("key", entry.getKey());
            generator.writeObjectField("value", entry.getValue());
            generator.writeEndObject();
        }       
        generator.writeEndArray();
    }    
}