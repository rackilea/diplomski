private void write(char buf[]) {
    try {
        synchronized (this) {
            ensureOpen();
            textOut.write(buf);
            textOut.flushBuffer();
            charOut.flushBuffer();
            if (autoFlush) {
                for (int i = 0; i < buf.length; i++)
                    if (buf[i] == '\n')
                        out.flush();
            }
        }
    }
    catch (InterruptedIOException x) {
        Thread.currentThread().interrupt();
    }
    catch (IOException x) {
        trouble = true;
    }
}