private byte[] unMask(byte[] mask, byte[] data) {
        for (int i = 0; i < data.length; i++) {
              data[i] = (byte) (data[i] ^ mask[i % mask.length]);
        }
        return data;
}