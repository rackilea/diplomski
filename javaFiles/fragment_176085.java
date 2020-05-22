public static byte[] readChunkedData(final InputStream stream, final int size) throws IOException {
        byte[] buffer = new byte[size];
        DataInputStream din = new DataInputStream(stream);
        din.readFully(buffer);
        return buffer;
    }