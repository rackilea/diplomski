@Override
public void serialize(Request value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
    jgen.writeStartArray(value.getDataList().size());
    for (Data data : value.getDataList()) {
        ((CBORGenerator) jgen).writeStartObject(1);
        jgen.writeFieldId(data.getItem());
        ((CBORGenerator) jgen).writeStartObject(1);
        if (data.getObject().getC() != null) {
            jgen.writeBooleanField("c", data.getObject().getC());
        }
        if (data.getObject().getP() != null) {
            jgen.writeNumberField("p", data.getObject().getP());
        }
        jgen.writeEndObject();
        jgen.writeEndObject();
    }
    jgen.writeEndArray();
}