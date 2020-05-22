/**
 * <code>DownloaderInputStream</code>
 */
public class DownloaderInputStream extends InputStream {

    /**
     * <code>IDownloadNotifier</code> - download listener.
     */
    public static interface IDownloadListener {

        /**
         * Notifies about download completion.
         *
         * @param buf
         * @param offset
         * @param length
         */
        public void onComplete(final byte[] buf, final int offset, final int length);
    }

    /**
     * <code>ByteArrayOutputStreamX</code> - {@link ByteArrayOutputStream}
     * extension that exposes buf variable (to avoid copying).
     */
    private final class ByteArrayOutputStreamX extends ByteArrayOutputStream {

        /**
         * Constructor.
         *
         * @param size
         */
        public ByteArrayOutputStreamX(final int size) {
            super(size);
        }

        /**
         * Returns inner buffer.
         *
         * @return inner buffer
         */
        public byte[] getBuffer() {
            return buf;
        }
    }

    private final class Downloader extends Object implements Runnable {
        // fields

        private final InputStream is;

        /**
         * Constructor.
         *
         * @param is
         */
        public Downloader(final InputStream is) {
            this.is = is;
        }

        // Runnable implementation
        public void run() {
            int read = 0;

            byte[] buf = new byte[16 * 1024];

            try {
                while ((read = is.read(buf)) != -1) {
                    if (read > 0) {
                        content.write(buf, 0, read);

                        downloadedBytes += read;
                    } else {
                        Thread.sleep(50);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            listener.onComplete(content.getBuffer(), 0 /*
                     * offset
                     */, downloadedBytes);
        }
    }
    // fields
    private final int contentLength;
    private final IDownloadListener listener;
    // state
    private ByteArrayOutputStreamX content;
    private volatile int downloadedBytes;
    private volatile int readBytes;

    /**
     * Constructor.
     *
     * @param contentLength
     * @param is
     * @param listener
     */
    public DownloaderInputStream(final int contentLength, final InputStream is, final IDownloadListener listener) {
        this.contentLength = contentLength;
        this.listener = listener;

        this.content = new ByteArrayOutputStreamX(contentLength);
        this.downloadedBytes = 0;
        this.readBytes = 0;

        new Thread(new Downloader(is)).start();
    }

    /**
     * Returns number of downloaded bytes.
     *
     * @return number of downloaded bytes
     */
    public int getDownloadedBytes() {
        return downloadedBytes;
    }

    /**
     * Returns number of read bytes.
     *
     * @return number of read bytes
     */
    public int getReadBytes() {
        return readBytes;
    }

    // InputStream implementation
    @Override
    public int available() throws IOException {
        return downloadedBytes - readBytes;
    }

    @Override
    public int read() throws IOException {
        // not implemented (not necessary for BasicPlayer)
        return 0;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (readBytes == contentLength) {
            return -1;
        }

        int tr = 0;

        while ((tr = Math.min(downloadedBytes - readBytes, len)) == 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {/*
                 * ignore
                 */

            }
        }

        byte[] buf = content.getBuffer();

        System.arraycopy(buf, readBytes, b, off, tr);

        readBytes += tr;

        return tr;
    }

    @Override
    public long skip(long n) throws IOException {
        // not implemented (not necessary for BasicPlayer)
        return n;
    }
}