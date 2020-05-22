byte[] MyShortToByte(short[] buffer) {
    int N = buffer.length;
    short min = 0;
    short max = 0;
    for (int i=0; i<N; i++) {
         if (buffer[i] > max) max = buffer[i];
         if (buffer[i] < min) min = buffer[i];
         }
    short scaling = 1+(max-min)/256; // 1+ ensures we stay within range and guarantee no divide by zero if sequence is pure silence ...

    ByteBuffer byteBuf = ByteBuffer.allocate(N);
    for (int i=0; i<N; i++) {
        byte b = (byte)(buffer[i]/scaling);  /*convert to byte. */
        byteBuf.put(b);
    }
    return byteBuf.array();
}