public int hashCode() {

    long bits = Double.doubleToLongBits(y);
    byte[] ybits = new byte[] {
        (byte)((y >> 56) & 0xff),
        (byte)((y >> 48) & 0xff),
        (byte)((y >> 40) & 0xff),
        (byte)((y >> 32) & 0xff),
        (byte)((y >> 24) & 0xff),
        (byte)((y >> 16) & 0xff),
        (byte)((y >> 8) & 0xff),
        (byte)((y >> 0) & 0xff),
    };
    byte[] xbits = new byte[] {
        (byte)((x >> 56) & 0xff),
        (byte)((x >> 48) & 0xff),
        (byte)((x >> 40) & 0xff),
        (byte)((x >> 32) & 0xff),
        (byte)((x >> 24) & 0xff),
        (byte)((x >> 16) & 0xff),
        (byte)((x >> 8) & 0xff),
        (byte)((x >> 0) & 0xff),
    };
    // this combines the bytes of X with the reversed order
    // bytes of Y, and then packs both of those into 4 bytes
    // because we need to return an int (4 bytes).
    byte[] xorbits = new byte[] {
         (xbits[0]^ybits[7])^(xbits[4]^ybits[3]),
         (xbits[1]^ybits[6])^(xbits[5]^ybits[2]),
         (xbits[2]^ybits[5])^(xbits[6]^ybits[1]),
         (xbits[3]^ybits[4])^(xbits[7]^ybits[0]),
    };

    int value = 0;
    for (int i = 0; i < 3; i++) {
       value = (value << 8) + (by[i] & 0xff);
    }
    return value;
}