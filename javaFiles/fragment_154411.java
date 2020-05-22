public byte[] floatArrayToBytes(float[] data {
    byte[] bytes = new byte[data.length * 2];
    float  scale = 1.0f;
    int    ix    = 0;

    for (float sample: data) {
        int value = sample * scale;
        bytes[ix++] = (byte) ((value >> 8) & 0x00ff);
        bytes[ix++] = (byte) (value & 0x00ff);
    }

 return bytes;