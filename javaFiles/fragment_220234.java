public class MessageHeadersJsonSerializer extends JsonSerializer<MessageHeaders>{
    @Override
    public void serializeWithType(MessageHeaders value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        typeSer.writeTypePrefixForObject(value, gen, HashMap.class);
        serialize(value, gen, serializers);
        typeSer.writeTypeSuffixForObject(value, gen);
    }

    @Override
    public void serialize(MessageHeaders value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        for(Map.Entry<String, Object> entry : value.entrySet()){
            gen.writeFieldName(entry.getKey());
            gen.writeObject(entry.getValue());
        }
    }
}