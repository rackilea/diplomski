public void close() throws IOException {
    synchronized (lock) {
        if (out == null) {
            return;
        }
        try {
            flushBuffer();
        } finally {
            out.close();  // this closes the FileWriter
            out = null;   // the original FileWriter passed to the BufferedWriter is still not null after this call
            cb = null;
        }
    }
}