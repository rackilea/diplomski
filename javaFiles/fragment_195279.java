private static final int[] DE_BRUIJN_BIT_POSITION_LUT = {
      0, 9, 1, 10, 13, 21, 2, 29, 11, 14, 16, 18, 22, 25, 3, 30,
      8, 12, 20, 28, 15, 17, 24, 7, 19, 27, 23, 6, 26, 5, 4, 31
    };

public static int nbBytes2(int n) {
    n |= n >> 1;  
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    n |= n >> 16;
    return DE_BRUIJN_BIT_POSITION_LUT[((n * 0x07C4ACDD) >> 27) & 0x1f] / 8 + 1;
}