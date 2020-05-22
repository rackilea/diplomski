import java.nio.ByteBuffer;

public class ByteBufferSerializer implements ByteSerializer {
    private final ByteBuffer buffer;

    public ByteBufferSerializer(int bufferCapacity) {
        if (bufferCapacity < 0) throw new IllegalArgumentException("bufferCapacity must not be negative.");

        this.buffer = ByteBuffer.allocate(bufferCapacity);
    }

    @Override
    public ByteSerializer put(byte value) {
        buffer.put(value);
        return this;
    }

    @Override
    public ByteSerializer putInt(int value) {
        buffer.putInt(value);
        return this;
    }

    @Override
    public ByteSerializer putLong(long value) {
        buffer.putLong(value);
        return this;
    }

    @Override
    public boolean isSerializing() {
        return true;
    }

    @Override
    public ByteSerializer add(int bytes) {
        if (bytes < 0) throw new IllegalArgumentException("bytes must not be negative.");

        for (int b = 0; b < bytes; b++) {
            buffer.put((byte)0);
        }
        return this;
        // or throw new UnsupportedOperationException();
    }

    @Override
    public int position() {
        return buffer.position();
    }

    public ByteBuffer buffer() {
        return buffer;
    }
}