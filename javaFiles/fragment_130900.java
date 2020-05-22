final class ByteWrapper {

    private final byte[] bytes;

    public ByteWrapper(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public boolean equals(Object o) {
        // type checks here
        ByteWrapper that = (ByteWrapper) o;
        return Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }
}