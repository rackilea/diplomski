class X implements Closeable {
    @Override
    public void close() throws IOException {
    }
}

...
    public static void main(String[] args) throws IOException {
        X x = new X(); <-- Eclipse warning
    }