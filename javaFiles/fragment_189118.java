static void close(Closeable closeable) throws IOException {
    try {
        closeable.close();
    }
    catch (IOException e) {
        if (!"closed".equals(e.getMessage())) {
            throw e;
        }
        // Otherwise, we're already closed, just ignore it,
    }
}