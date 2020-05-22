static double sqrt(int n) {
    if(n > 0) {
        return Math.sqrt(n);
    }
    throw new IllegalArgumentException("Invalid integer: " + n);
}