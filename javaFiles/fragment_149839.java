public class MySerializer extends JsonSerializer<TryToSerialize> {
    @Override
    public void serialize(TryToSerialize toSerialize, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        jgen.writeNumber(toSerialize.getNumber());
        jgen.writeString(toSerialize.getWord());
        for (Iterator<String> iterator = toSerialize.iterator(); iterator.hasNext();) {
            jgen.writeString((String) iterator.next());         
        }
        jgen.writeEndArray();
    }
}