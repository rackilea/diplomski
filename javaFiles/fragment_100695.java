class SampleSerializer extends JsonSerializer<Sample> {

    @Override
    public void serialize(Sample sample, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("prop1", sample.getProp1());
        jgen.writeStringField("prop2", sample.getProp2());
        jgen.writeEndObject();
    }
}