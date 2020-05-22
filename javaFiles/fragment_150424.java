public class BytesToStringSerializer extends StdSerializer<byte[]> {

    public BytesToStringSerializer() {
        super(byte[].class);
    }

    protected BytesToStringSerializer(Class<byte[]> t) {
        super(t);
    }

    @Override
    public void serialize(byte[] value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String yourReadableString = new String(value, StandardCharsets.UTF_8);
        gen.writeString(yourReadableString);
    }
}