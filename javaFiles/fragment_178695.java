// Util class
private static final class SubStream extends FilterInputStream {
    private final long length;
    private long pos;

    public SubStream(final InputStream stream, final long length) {
        super(stream);

        this.length = length;
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int available() throws IOException {
        return (int) Math.min(super.available(), length - pos);
    }

    @Override
    public int read() throws IOException {
        if (pos++ >= length) {
            return -1;
        }

        return super.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (pos >= length) {
            return -1;
        }

        int count = super.read(b, off, (int) Math.min(len, length - pos));

        if (count < 0) {
            return -1;
        }

        pos += count;

        return count;
    }

    @Override
    public long skip(long n) throws IOException {
        if (pos >= length) {
            return -1;
        }

        long skipped = super.skip(Math.min(n, length - pos));

        if (skipped < 0) {
            return -1;
        }

        pos += skipped;

        return skipped;
    }

    @Override
    public void close() throws IOException {
        // Don't close wrapped stream, just consume any bytes left
        while (pos < length) {
            skip(length - pos);
        }
    }
}