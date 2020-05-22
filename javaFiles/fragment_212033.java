public void close() throws IOException {
synchronized (lock) {
    if (out == null) {
    return;
    }
    try {
        flushBuffer();
    } finally {
        out.close();
        out = null;
        cb = null;
    }
}
}