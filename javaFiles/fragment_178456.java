class CustomSerializer extends JsonSerializer<ARow> {
@Override
public Class<ARow> handledType() {
    return ARow.class;
}

public void serialize(ARow value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    jgen.writeStringField("ounc", value.ounces.toLowerCase()); //Do this for all of your relevant properties..
    jgen.writeEndObject();
}