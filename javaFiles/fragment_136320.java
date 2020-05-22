public class ByteArray2dConverter extends DozerConverter<byte[][], byte[][]> {

    public ByteArray2dConverter() {
        super(byte[][].class, byte[][].class);
    }

    public byte[][] convertTo(byte[][] source, byte[][] destination) {
        if (source == null) {
            return null;
        }
        byte[][] result = new byte[source.length][];
        for (int i = 0; i < source.length; i++) {
            byte[] element = source[i];
            if (element != null) {
                result[i] = Arrays.copyOf(element, element.length);
            }
        }
        return result;
    }

    public byte[][] convertFrom(byte[][] source, byte[][] destination) {
        return convertTo(source, destination);
    }
}