private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;

private StreamEncoder(OutputStream out, Object lock, CharsetEncoder enc) {
    // some deleted
    if (ch == null) {
        bb = ByteBuffer.allocate(DEFAULT_BYTE_BUFFER_SIZE);
    }
}