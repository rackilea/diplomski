public String toDecimalString() {
    Formatter f = new Formatter();
    f.format("%d", digits[0]);
    for(int i = 1 ; i < digits.length; i++) {
        f.format("%09d", digits[i]);
    }
    return f.toString();
}