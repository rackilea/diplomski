public boolean hasNextFloat() {
    setRadix(10);
    boolean result = hasNext(floatPattern());
    if (result) { // Cache it
        try {
            String s = processFloatToken(hasNextResult);
            typeCache = Float.valueOf(Float.parseFloat(s));
        } catch (NumberFormatException nfe) {
            result = false;
        }
    }
    return result;
}