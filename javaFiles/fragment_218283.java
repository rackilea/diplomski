public final class DevNull { 
    public final static PrintStream out = new PrintStream(new OutputStream() {
        public void close() {}
        public void flush() {}
        public void write(byte[] b) {}
        public void write(byte[] b, int off, int len) {}
        public void write(int b) {}

    } );
}