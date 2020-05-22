public String truncateNumber(float floatNumber) {
    long million = 1000000L;
    long billion = 1000000000L;
    long trillion = 1000000000000L;
    long number = Math.round(floatNumber);
    if ((number >= million) && (number < billion)) {
        float fraction = calculateFraction(number, million);
        return Float.toString(fraction) + "M";
    } else if ((number >= billion) && (number < trillion)) {
        float fraction = calculateFraction(number, billion);
        return Float.toString(fraction) + "B";
    }
    return Long.toString(number);
}

public float calculateFraction(long number, long divisor) {
    long truncate = (number * 10L + (divisor / 2L)) / divisor;
    float fraction = (float) truncate * 0.10F;
    return fraction;
}