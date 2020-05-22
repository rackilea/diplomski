@SuppressWarnings("unchecked")
public static <N extends Number> N getOddBits(Class<N> cls) {
    Number out;
    if (cls == Byte.class) {
        out = (byte)0xAA;
    } else if (cls == Short.class) {
        out = (short)0xAAAA;
    } else if (cls == Integer.class) {
        out = 0xAAAAAAAA;
    } else if (cls == Float.class) {
        out = Float.intBitsToFloat(0xAAAAAAAA);
    } else if (cls == Long.class) {
        out = 0xAAAAAAAAAAAAAAAAL;
    } else if (cls == Double.class) {
        out = Double.longBitsToDouble(0xAAAAAAAAAAAAAAAAL);
    } else {
        throw new IllegalArgumentException();
    }
    return (N)out;
}