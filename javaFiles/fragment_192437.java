public int nextInt() {
    return nextInt(defaultRadix);
}

public int nextInt(int radix) {
    // Check cached result
    if ((typeCache != null) && (typeCache instanceof Integer)
        && this.radix == radix) {
        int val = ((Integer)typeCache).intValue();
        useTypeCache();
        return val;
    }.......