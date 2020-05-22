public class NonCloseableOutputStream extends java.io.FilterOutputStream {
    public NonCloseableOutputStream(OutputStream out) {
        super(out);
    }

    @Override public void close() throws IOException {
        flush();
    }
}