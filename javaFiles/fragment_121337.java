import java.io.IOException;
import java.io.InputStream;

/**
 * An {@code InputStream} wrapper that provides up to a maximum number of
 * bytes from the underlying stream.  Does not support mark/reset, even
 * when the wrapped stream does, and does not perform any buffering.
 */
public class BoundedInputStream extends InputStream {

    /** This stream's underlying @{code InputStream} */
    private final InputStream data;

    /** The maximum number of bytes still available from this stream */ 
    private long bytesRemaining;

    /**
     * Initializes a new {@code BoundedInputStream} with the specified
     * underlying stream and byte limit
     * @param data the @{code InputStream} serving as the source of this
     *        one's data
     * @param maxBytes the maximum number of bytes this stream will deliver
     *        before signaling end-of-data
     */
    public BoundedInputStream(InputStream data, long maxBytes) {
        this.data = data;
        bytesRemaining = Math.max(maxBytes, 0);
    }

    @Override
    public int available() throws IOException {
        return (int) Math.min(data.available(), bytesRemaining);
    }

    @Override
    public void close() throws IOException {
        data.close();
    }

    @Override
    public synchronized void mark(int limit) {
        // does nothing
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read(byte[] buf, int off, int len) throws IOException {
        if (bytesRemaining > 0) {
            int nRead = data.read(
                    buf, off, (int) Math.min(len, bytesRemaining));

            bytesRemaining -= nRead;

            return nRead;
        } else {
            return -1;
        }
    }

    @Override
    public int read(byte[] buf) throws IOException {
        return this.read(buf, 0, buf.length);
    }

    @Override
    public synchronized void reset() throws IOException {
        throw new IOException("reset() not supported");
    }

    @Override
    public long skip(long n) throws IOException {
        long skipped = data.skip(Math.min(n, bytesRemaining));

        bytesRemaining -= skipped;

        return skipped;
    }

    @Override
    public int read() throws IOException {
        if (bytesRemaining > 0) {
            int c = data.read();

            if (c >= 0) {
                bytesRemaining -= 1;
            }

            return c;
        } else {
            return -1;
        }
    }
}