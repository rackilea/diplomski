String getPascalString(ByteBuffer buffer) {
    int length = buffer.get() & 0xFF;
    byte[] bytes = new byte[length];
    buffer.get(bytes);
    return new String(bytes, StandardCharsets.ISO_8859_1);
}