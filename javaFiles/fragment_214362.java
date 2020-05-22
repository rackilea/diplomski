byte[] data = new byte[4];
data[0] = (byte)((n >> 4) & 0xf);
data[1] = (byte)(n & 0xf);
data[2] = (byte)((n >> 12) & 0xf);
data[3] = (byte)((n >> 8) & 0xf);
for(int i = 0; i < 4; ++i) {
    data[i] += (data[i] < 10) ? '0' : ('A' - 10);
}