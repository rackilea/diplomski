protected LookupOp createColorizeOp(short R1, short G1, short B1) {
    short[] alpha = new short[256];
    short[] red = new short[256];
    short[] green = new short[256];
    short[] blue = new short[256];

    int Y = 0.3*R + 0.59*G + 0.11*B

    for (short i = 0; i < 256; i++) {
        alpha[i] = i;
        red[i] = (R1 + i*.3)/2;
        green[i] = (G1 + i*.59)/2;
        blue[i] = (B1 + i*.11)/2;
    }

    short[][] data = new short[][] {
            red, green, blue, alpha
    };

    LookupTable lookupTable = new ShortLookupTable(0, data);
    return new LookupOp(lookupTable, null);
}