private void writeInt(int val, byte[] data, int offset) {
    data[offset    ] = (byte)(val >>> 24);
    data[offset + 1] = (byte)(val >>> 16);
    data[offset + 2] = (byte)(val >>> 8);
    data[offset + 3] = (byte)val;
}

private int readInt(byte[] data, int offset) {
    return (data[offset] << 24)
            | ((data[offset + 1] & 0xFF) << 16)
            | ((data[offset + 2] & 0xFF) << 8)
            | (data[offset + 3] & 0xFF);
}