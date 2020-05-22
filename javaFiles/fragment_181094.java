public static void callMethod(byte[] bytes) {
    int bits = (bytes[2] & 0xFF) << 16 +
               (bytes[1] & 0xFF) << 8 + 
               (bytes[0] & 0xFF);
    if ((bits & 1) > 0) {
        methodForBit0Set(bytes);
    }
    if ((bits & 2) > 0) {
        methodForBit1Set(bytes);
    }
    if ((bits & 4) > 0) {
        methodForBit3Set(bytes);
    }
    // etc
}