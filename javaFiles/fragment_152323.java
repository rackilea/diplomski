private boolean closing = false; /* To avoid recursive closing */

/**
 * Close the stream.  This is done by flushing the stream and then closing
 * the underlying output stream.
 *
 * @see        java.io.OutputStream#close()
 */
public void close() {
synchronized (this) {
    if (! closing) {
    closing = true;
    try {
        textOut.close();
        out.close();
    }
    catch (IOException x) {
        trouble = true;
    }
    textOut = null;
    charOut = null;
    out = null;
    }
}
}