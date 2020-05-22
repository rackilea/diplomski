public static boolean isPowerOfTwo(float i) {
    int bits = Float.floatToIntBits(i);
    if((bits & ((1 << 23)-1)) != 0)
        return ((bits & (bits-1)) == 0); // denormalized number
    int power = bits >>> 23;
    return power > 0 && power < 255; // 255 = Infinity; higher values = negative numbers
}