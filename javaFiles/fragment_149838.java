public class MySerializer extends JsonSerializer<TryToSerialize> {
    @Override
    public void serialize(TryToSerialize toSerialize, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("number", toSerialize.getNumber());
        jgen.writeStringField("word", toSerialize.getWord());
        provider.defaultSerializeField("values", toSerialize.iterator(), jgen);
        jgen.writeEndObject();
    }
}