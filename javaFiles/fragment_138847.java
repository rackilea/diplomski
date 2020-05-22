float ulp(float x) {
    int repr;
    float next;
    if (Float.isNaN(x)) return Float.NaN; //special handling, to be safe
    repr = Float.floatToIntBits(x);
    x++; //will work correctly independently of sign
    next = Float.intBitsToFloat(repr)
    return next-x;
}