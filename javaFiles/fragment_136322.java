public class ByteArray1dConverter extends DozerConverter<byte[], byte[]> {

    public ByteArray1dConverter() {
        super(byte[].class, byte[].class);
    }

    public byte[] convertTo(byte[] source, byte[] destination) {
        return source == null ? null : Arrays.copyOf(source, source.length);
    }

    public byte[] convertFrom(byte[] source, byte[] destination) {
        return convertTo(source, destination);
    }
}