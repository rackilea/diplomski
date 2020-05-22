/**
 * Flushes this buffered output stream. This forces any buffered
 * output bytes to be written out to the underlying output stream.
 *
 * @exception  IOException  if an I/O error occurs.
 * @see        java.io.FilterOutputStream#out
 */
public synchronized void flush() throws IOException {
    flushBuffer();
    out.flush();
}

/** Flush the internal buffer */
private void flushBuffer() throws IOException {
    if (count > 0) {
        out.write(buf, 0, count);
        count = 0;
    }
}