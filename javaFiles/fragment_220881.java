public void close() throws IOException {
    synchronized (lock) {
        if (out == null) {
            return;
        }
        try (Writer w = out) {
            flushBuffer();
        } finally {
            out = null;
            cb = null;
        }
    }
}