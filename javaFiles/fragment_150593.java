byte[] MyShortToByte(short[] buffer) {
    int N = buffer.length;
    ByteBuffer byteBuf = ByteBuffer.allocate(N);
    while (N >= i) {
        byte b = (byte)(buffer[i]/256);  /*convert to byte. */
        byteBuf.put(b);
        i++;
    }
    return byteBuf.array();
}