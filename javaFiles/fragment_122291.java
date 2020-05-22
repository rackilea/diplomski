public String toDecimalString() {
    Formatter f = new Formatter();
    for(int digit : digits) {
        f.format("%09d", digit);
    }
    return f.toString();
}