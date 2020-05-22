public class ByteArray {
    public final byte[] bytes;
    public ByteArray(byte[] bytes) {
        this.bytes = bytes;
    }
    @Override
    public boolean equals(Object rhs) {
        return rhs != null && rhs instanceof ByteArray
            && Arrays.equals(bytes, ((ByteArray)rhs).bytes);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }
}