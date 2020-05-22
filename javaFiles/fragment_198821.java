/**
 * The internal buffer where data is stored.
 */
protected byte buf[];

/**
 * Creates a new buffered output stream to write data to the
 * specified underlying output stream.
 *
 * @param   out   the underlying output stream.
 */
public BufferedOutputStream(OutputStream out) {
    this(out, 8192);
}

/**
 * Creates a new buffered output stream to write data to the
 * specified underlying output stream with the specified buffer
 * size.
 *
 * @param   out    the underlying output stream.
 * @param   size   the buffer size.
 * @exception IllegalArgumentException if size &lt;= 0.
 */
public BufferedOutputStream(OutputStream out, int size) {
    super(out);
    if (size <= 0) {
        throw new IllegalArgumentException("Buffer size <= 0");
    }
    buf = new byte[size];
}