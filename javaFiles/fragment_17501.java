@Override
public void close() throws IOException {
    try (Closeable cc = c;
         Closeable bb = b;
         Closeable aa = a;) {
        // do nothing
    }
}