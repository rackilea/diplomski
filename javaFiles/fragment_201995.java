class ProgressCounter extends FilterReader {
    long progress = 0;

    @Override
    public long skip(long n) throws IOException {
        progress += n;
        return super.skip(n);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int red = super.read(cbuf, off, len);
        progress += red;
        return red;
    }

    @Override
    public int read() throws IOException {
        int red = super.read();
        progress += red;
        return red;
    }

    public ProgressCounter(Reader in) {
        super(in);
    }

    public long getProgress () {
        return progress;
    }
}