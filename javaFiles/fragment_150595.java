byte[] MyShortToByte(short[] buffer) {
    int N = buffer.length;
    float f[] = new float[N];
    float min = 0.0f;
    float max = 0.0f;
    for (int i=0; i<N; i++) {
         f[i] = (float)(buffer[i]);
         if (f[i] > max) max = f[i];
         if (f[i] < min) min = f[i];
         }
    float scaling = 1.0f+(max-min)/256.0f; // +1 ensures we stay within range and guarantee no divide by zero if sequence is pure silence ...

    ByteBuffer byteBuf = ByteBuffer.allocate(N);
    for (int i=0; i<N; i++) {
        byte b = (byte)(f[i]/scaling);  /*convert to byte. */
        byteBuf.put(b);
    }
    return byteBuf.array();
}