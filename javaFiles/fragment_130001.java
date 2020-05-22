private static class MongoDateSerializer extends JsonSerializer<Date> {

    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        TokenBuffer buffer = (TokenBuffer) jgen;
        ObjectCodec codec = buffer.getCodec();
        buffer.setCodec(null);

        buffer.writeObject(value);

        buffer.setCodec(codec);
    }
}