public class SwitchableIdSerializer extends JsonSerializer<SwitchableId> {

    @Override
    public void serialize(SwitchableId data, JsonGenerator json, SerializerProvider provider) throws IOException,
    JsonGenerationException {
        json.writeFieldName(data.id + "|" + data.type);
    }
}