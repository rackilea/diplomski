public class StreamInputStream extends InputStream {
    final Spliterator<? extends InputStream> source;
    final Consumer<InputStream> c = is -> in = Objects.requireNonNull(is);
    InputStream in;

    public StreamInputStream(Stream<? extends InputStream> sourceStream) {
        (source = sourceStream.spliterator()).tryAdvance(c);
    }
    public StreamInputStream(InputStream first, InputStream second) {
        this(Stream.of(first, second));
    }
    public int available() throws IOException {
        return in == null? 0: in.available();
    }
    public int read() throws IOException {
        if(in == null) return -1;
        int b; do b = in.read(); while(b<0 && next());
        return b;
    }
    public int read(byte b[], int off, int len) throws IOException {
        if((off|len) < 0 || len > b.length - off) throw new IndexOutOfBoundsException();
        if(in == null) return -1; else if(len == 0) return 0;
        int n; do n = in.read(b, off, len); while(n<0 && next());
        return n;
    }
    public void close() throws IOException {
        closeCurrent();
    }
    private boolean next() throws IOException {
        closeCurrent();
        return source.tryAdvance(c);
    }
    private void closeCurrent() throws IOException {
        if(in != null) try { in.close(); } finally { in = null; }
    }
}