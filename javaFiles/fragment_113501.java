public void rotateLeft(byte[] data) {
    byte t = (byte)((data[0] >>> 7) & 0x001);
    for (int i = 0; i < (data.length - 1); ++i) {
        data[i] = (byte)(((data[i] << 1) & 0x0FE) | ((data[i + 1] >>> 7) & 0x001));
    }
    data[data.length - 1] = (byte)(((data[data.length - 1] << 1) & 0x0FE) | t);
}