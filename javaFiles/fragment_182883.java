void close(Closeable c) {
    if (c != null) {
        try {
            c.close();
        } catch (IOException e) {
            // perform logging or just ignore error
        }
    }
}