@Component
@Slf4j
public class AvroKafkaMessageConverter extends AvroSchemaRegistryClientMessageConverter {

  public AvroKafkaMessageConverter(SchemaRegistryClient schemaRegistryClient) {
    super(schemaRegistryClient, new NoOpCacheManager());
  }

  public <T> T convertFromInternal(ConsumerRecord<?, ?> consumerRecord, Class<T> targetClass,
      Object conversionHint) {
    T result;
    try {
      byte[] payload = (byte[]) consumerRecord.value();

      Map<String, String> headers = new HashMap<>();
      consumerRecord.headers().forEach(header -> headers.put(header.key(), asString(header.value())));

      MimeType mimeType = messageMimeType(conversionHint, headers);
      if (mimeType == null) {
        return null;
      }

      Schema writerSchema = resolveWriterSchemaForDeserialization(mimeType);
      Schema readerSchema = resolveReaderSchemaForDeserialization(targetClass);

      @SuppressWarnings("unchecked")
      DatumReader<Object> reader = getDatumReader((Class<Object>) targetClass, readerSchema, writerSchema);
      Decoder decoder = DecoderFactory.get().binaryDecoder(payload, null);
      result = (T) reader.read(null, decoder);
    }
    catch (IOException e) {
      throw new RuntimeException("Failed to read payload", e);
    }
    return result;
  }

  private MimeType messageMimeType(Object conversionHint, Map<String, String> headers) {
    MimeType mimeType;
    try {
      String contentType = headers.get(MessageHeaders.CONTENT_TYPE);
      log.debug("contentType: {}", contentType);
      mimeType = MimeType.valueOf(contentType);
    } catch (InvalidMimeTypeException e) {
      log.error("Exception getting object MimeType from contentType header", e);
      if (conversionHint instanceof MimeType) {
        mimeType = (MimeType) conversionHint;
      }
      else {
        return null;
      }
    }
    return mimeType;
  }

  private String asString(byte[] byteArray) {
    String theString = new String(byteArray, Charset.defaultCharset());
    return theString.replace("\"", "");
  }
}