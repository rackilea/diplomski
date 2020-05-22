static void writeString(final DataOutputStream out, final String str) throws IOException {
    final byte[] bytes = str.getBytes(UTF_8);
    short len = (short) bytes.length;
    if (bytes.length >= 0x0010) {
        len++;
    }
    out.writeShort(len);
    out.write(bytes);
}

static String readString(final DataInputStream in) throws IOException {
    int len = in.readUnsignedShort();
    if (len == 0x0010) {
        throw new IllegalStateException();
    } else if (len > 0x0010) {
        len--;
    }
    final byte[] bytes = new byte[len];
    in.read(bytes);
    return new String(bytes, UTF_8);
}