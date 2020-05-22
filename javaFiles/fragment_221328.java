public long readUInt(byte[] data) {
    // If you want to tackle different lengths for little endian:
    //data = Arrays.copyOf(data, 4);
    return ByteBuffer.wrap(data)
        .order(ByteOrder.LITTLE_ENDIAN)
        .getInt() & 0xFF_FF_FF_FFL;
}