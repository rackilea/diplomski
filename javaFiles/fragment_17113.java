public class LimitingOutputStream extends OutputStream {
    private final OutputStream stream;
    private final long limitInBytes;
    private final AtomicLong bytesWritten = new AtomicLong();

    public LimitingOutputStream(@NotNull OutputStream out, long limitInBytes) {
        stream = out;
        this.limitInBytes = limitInBytes;
    }

    @Override
    public void write(int b) throws IOException {
        increaseCounterAndValidateNotOverflown(1);
        stream.write(b);
    }

    @Override
    public void write(@NotNull byte[] b) throws IOException {
        increaseCounterAndValidateNotOverflown(b.length);
        stream.write(b);
    }

    @Override
    public void write(@NotNull byte[] b, int off, int len) throws IOException {
        increaseCounterAndValidateNotOverflown(len);
        stream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }

    private void increaseCounterAndValidateNotOverflown(int delta) throws IOException {
        long count = bytesWritten.addAndGet(delta);
        if (count > limitInBytes) {
            throw new IOException(String.format("Output stream overflown; only %d allowed, but tried to write %d bytes", limitInBytes, count));
        }
    }
}