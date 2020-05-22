static String readString(final DataInputStream in) throws IOException {
    int len = in.readUnsignedShort();
    final byte[] bytes = new byte[len];
    in.read(bytes);
    if (bytes[len - 1] == -1) {
        len--;
    }
    return new String(bytes, 0, len, UTF_8);
}