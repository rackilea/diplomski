public synchronized static byte[] encode(int key) {
        encoded[0] = (byte)(key >> 24);
        encoded[1] = (byte)(key >> 16);
        encoded[2] = (byte)(key >> 8);
        encoded[3] = (byte)(key);
        return encoded;
    }