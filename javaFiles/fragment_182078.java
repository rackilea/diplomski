public int[] pack(byte[] bytes) {
    int n = bytes.length >> 1;
    int[] packed = new int[n];
    for (int i = 0; i < n; ++i) {
        int i2 = i << 1;
        int b1 = bytes[i2] & 0xff;
        int b2 = bytes[i2 + 1] & 0xff;
        packed[i] = (b1 << 8) | b2;
    }
    return packed;
}