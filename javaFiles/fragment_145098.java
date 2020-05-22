/**
 * Jackson serializer for MongoDB legacy UUIDs.  An LUUID is composed of a Base64 encoded UUID, and a type.
 *
 * <p><p><p>
 * Example as JSON serialized string:
 * <pre>
 * {@code
 *  {"$binary": "a0i407ZPz66d8XbdAZMygQ==", "$type": "03"}
 * }
 * </pre>
 */
public class LegacyUuidSerializer extends StdSerializer<UUID> {
    public LegacyUuidSerializer() {
        super(UUID.class);
    }

    @Override
    public void serialize(UUID value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        byte[] bytes = new byte[16];
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.putLong(value.getMostSignificantBits());
        byteBuffer.putLong(value.getLeastSignificantBits());
        String base64EncodedUuid = Base64.getEncoder().encodeToString(bytes);
        generator.writeStartObject();
        generator.writeStringField("$binary", base64EncodedUuid);
        generator.writeStringField("$type", "03"); // Assume always type 3.
        generator.writeEndObject();
    }
}