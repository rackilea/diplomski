public static class SplitOutputStream extends OutputStream {
    private final OutputStream out1;
    private final OutputStream out2;

    public SplitOutputStream(OutputStream out1, OutputStream out2) {
        this.out1 = out1;
        this.out2 = out2;
    }

    @Override public void write(int b) throws IOException {
        out1.write(b);
        out2.write(b);
    }

    @Override public void write(byte b[]) throws IOException {
        out1.write(b);
        out2.write(b);
    }

    @Override public void write(byte b[], int off, int len) throws IOException {
        out1.write(b, off, len);
        out2.write(b, off, len);
    }

    @Override public void flush() throws IOException {
        out1.flush();
        out2.flush();
    }

    /** Closes all the streams. If there was an IOException this throws the first one. */
    @Override public void close() throws IOException {
        IOException ioException = null;
        for (OutputStream o : new OutputStream[] {
                out1,
                out2 }) {
            try {
                o.close();
            } catch (IOException e) {
                if (ioException == null) {
                    ioException = e;
                }
            }
        }
        if (ioException != null) {
            throw ioException;
        }
    }
}