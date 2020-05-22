/**
 * Jackson deserializer for MongoDB legacy UUIDs.  An LUUID is composed of a Base64 encoded UUID, and a type.
 *
 * <p><p><p>
 * Example as JSON serialized string:
 * <pre>
 * {@code
 *  {"$binary": "a0i407ZPz66d8XbdAZMygQ==", "$type": "03"}
 * }
 * </pre>
 */
public class LegacyUuidDeserializer extends StdDeserializer<UUID> {
    public LegacyUuidDeserializer() {
        super(UUID.class);
    }

    @Override
    public UUID deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        parser.nextToken(); // $binary
        parser.nextToken(); // Base64 encoded UUID.
        String base64EncodedUuid = parser.getText();
        parser.nextToken(); // $type
        parser.nextToken(); // $type value, e.g. 03
        byte[] bytes = Base64.getDecoder().decode(base64EncodedUuid);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long mostSigBits = byteBuffer.getLong();
        long leastSigBits = byteBuffer.getLong();
        return new UUID(mostSigBits, leastSigBits);
    }
}