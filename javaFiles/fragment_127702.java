public void write(int b) {
    try {
        synchronized (this) {
        ensureOpen();
        out.write(b);
        if ((b == '\n') && autoFlush)
            out.flush();
        }
    }
    catch (InterruptedIOException x) {
        Thread.currentThread().interrupt();
    }
    catch (IOException x) {
        trouble = true;
    }
}