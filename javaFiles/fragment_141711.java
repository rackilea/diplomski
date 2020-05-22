cLass SubStream extends FilterInputStream {
    private long offset;
    public SubStream(long offset, InputStream parent) {
        super(parent);
        this.offset = offset;
    }
    public SubStream(InputStream parent) {
        this(0, parent);
    }
    @Override public void reset() throws IOException {
        in.reset();
        in.skip(offset);
    }
    public SubStream subStream(long offset) {
        return new FilterInputStream(this.offset + offset, in);
    }
    public Object syncObject() {
        return in;
    }
}