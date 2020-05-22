public final class BitInputStream implements Closeable {

    private final InputStream in;
    private final ByteOrder streamBitOrder;
    private int bits;
    private byte bitsLeft;

    public BitInputStream(InputStream in) {
        this(in, ByteOrder.BIG_ENDIAN);
    }

    public BitInputStream(InputStream in, ByteOrder bitOrder) {
        Objects.requireNonNull(in);
        Objects.requireNonNull(bitOrder);
        this.in = in;
        this.streamBitOrder = bitOrder;
    }

    @Override
    public void close() throws IOException {
        this.in.close();
    }

    public int readBit() throws IOException {
        if (this.bitsLeft == 0) {
            if ((this.bits = this.in.read()) == -1)
                throw new EOFException();
            this.bitsLeft = 8;
        }
        int bitIdx = (this.streamBitOrder == ByteOrder.BIG_ENDIAN ? this.bitsLeft - 1 : 8 - this.bitsLeft);
        this.bitsLeft--;
        return (this.bits >> bitIdx) & 1;
    }

    public int readInt() throws IOException {
        return readInt(Integer.SIZE, this.streamBitOrder);
    }

    public int readInt(ByteOrder bitOrder) throws IOException {
        return readInt(Integer.SIZE, bitOrder);
    }

    public int readInt(int len) throws IOException {
        return readInt(len, this.streamBitOrder);
    }

    public int readInt(int len, ByteOrder bitOrder) throws IOException {
        if (len == 0)
            return 0;
        if (len < 0 || len > Integer.SIZE)
            throw new IllegalArgumentException("Invalid len: " + len + " (must be 0-" + Integer.SIZE + ")");
        int value = 0;
        if (bitOrder == ByteOrder.BIG_ENDIAN) {
            for (int i = 0; i < len; i++)
                value = (value << 1) | readBit();
        } else {
            for (int i = 0; i < len; i++)
                value |= readBit() << i;
        }
        return value;
    }

}