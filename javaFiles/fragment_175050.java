static double sqrt(int n) {
    if(n > 0) {
        return Math.sqrt(n);
    }
    throw new InvalidIntegerException(n);
}

static class InvalidIntegerException extends RuntimeException {

    private final Integer n;

    InvalidIntegerException(int n) {
        super("Invalid integer:  " + n);
        this.n = n;
    }

    public Integer getInteger() {
        return n;
    }
}