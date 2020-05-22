final class CloseableStreamFix extends ImageInputStreamImpl {

    private boolean closed;
    private final ImageInputStream delegate;

    public CloseableStreamFix(ImageInputStream delegate) {
        this.delegate = delegate;
    }

    // The method you actually want to override.
    @Override
    public void close() throws IOException {
        if (!closed) {
            closed = true;

            super.close();
            delegate.close();
        }
    }

    // You have to implement these abstract read methods. Easy, just delegate them.
    // ...except you need to keep the stream position in sync.
    @Override
    public int read() throws IOException {
        streamPos++;
        return delegate.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = delegate.read(b, off, len);

        if (read > 0) {
            streamPos += read;
        }

        return read;
    }

    // In a perfect world, the above should be all you need to do. Unfortunately, it's not.


    // We need to keep the delegate position in sync with the position in this class.
    // Overriding the seek method should do.
    @Override
    public void seek(long pos) throws IOException {
        super.seek(pos); // Don't forget to call super here, as we rely on positions being in sync.
        delegate.seek(pos);
    }

    // Some plugins require stream length, so we need to delegate that.
    @Override
    public long length() {
        try {
            // Unfortunately, this method does not declare IOException like the
            // interface method does, so we need this strange try/catch here.
            return delegate.length();
        } catch (IOException e) {
            // It's also possible to use a generics hack to throw a checked
            // exception as unchecked. I leave that as an exercise...
            throw new UndeclaredThrowableException(e);
        }
    }

    // You may be able to skip the flush methods. If you do, skip both.
    @Override
    public void flushBefore(long pos) throws IOException {
        delegate.flushBefore(pos);
    }

    @Override
    public long getFlushedPosition() {
        return delegate.getFlushedPosition();
    }

    // You could probably skip the methods below, as I don't think they are ever used as intended.
    @Override
    public boolean isCached() {
        return delegate.isCached();
    }

    @Override
    public boolean isCachedMemory() {
        return delegate.isCachedMemory();
    }

    @Override
    public boolean isCachedFile() {
        return delegate.isCachedFile();
    }
}