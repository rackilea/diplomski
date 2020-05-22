public class BarSerializer extends JsonSerializer<Bar> {

    @Override
    public void serialize(final Bar value, final JsonGenerator jgen,
            final SerializerProvider provider) throws IOException,
            JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeFieldName("myBar");
        jgen.writeString(value.getTwo());
        jgen.writeEndObject();
    }
}