class JacksonCodec<T> implements Codec<T> {
    private final ObjectMapper objectMapper;
    private final Codec<BsonDocument> rawBsonDocumentCodec;
    private final Class<T> type;

    public JacksonCodec(ObjectMapper objectMapper,
                        CodecRegistry codecRegistry,
                        Class<T> type) {
        this.objectMapper = objectMapper;
        this.rawBsonDocumentCodec = codecRegistry.get(BsonDocument.class);
        this.type = type;
    }

    @Override
    public T decode(BsonReader reader, DecoderContext decoderContext) {
        try {
            //https://stackoverflow.com/questions/35209839/converting-document-objects-in-mongodb-3-to-pojos
            JsonWriterSettings settings = JsonWriterSettings.builder().int64Converter((value, writer) -> writer.writeNumber(value.toString())).build();

            BsonDocument document = rawBsonDocumentCodec.decode(reader, decoderContext);
            String json = document.toJson(settings);
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void encode(BsonWriter writer, Object value, EncoderContext encoderContext) {
        try {

            String json = objectMapper.writeValueAsString(value);

            rawBsonDocumentCodec.encode(writer, RawBsonDocument.parse(json), encoderContext);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public Class<T> getEncoderClass() {
        return this.type;
    }
}