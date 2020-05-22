public BigDecimal(int val) {
    intCompact = val;
}

public BigDecimal(String val) {
    this(val.toCharArray(), 0, val.length());
}

public BigDecimal(char[] in, int offset, int len) {
       ...very long
}