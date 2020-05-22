public class ByteCountSerializer implements ByteSerializer {
    private int count = 0;

    @Override
    public ByteSerializer put(byte value) {
        count += 1;
        return this;
    }

    @Override
    public ByteSerializer putInt(int value) {
        count += 4;
        return this;
    }

    @Override
    public ByteSerializer putLong(long value) {
        count += 8;
        return this;
    }

    @Override
    public boolean isSerializing() {
        return false;
    }

    @Override
    public ByteSerializer add(int bytes) {
        if (bytes < 0) throw new IllegalArgumentException("bytes must not be negative.");

        count += bytes;
        return this;
    }

    @Override
    public int position() {
        return count;
    }
}