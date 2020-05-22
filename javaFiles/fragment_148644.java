public static short floatToShort(float x) {
    if (x < Short.MIN_VALUE) {
        return Short.MIN_VALUE;
    }
    if (x > Short.MAX_VALUE) {
        return Short.MAX_VALUE;
    }
    return (short) Math.round(x);
}