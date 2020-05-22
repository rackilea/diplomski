public int precision() {
    int result = precision;
    if (result == 0) {
        long s = intCompact;
        if (s != INFLATED)
            result = longDigitLength(s);
        else
            result = bigDigitLength(inflate());
        precision = result;
    }
    return result;
}