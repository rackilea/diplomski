static final String[] MONTHS = {"January", "February", ... };
static String getMonthName(int month) {
    checkBoundaries(month, 0, MONTHS.length - 1, String.format("Month %d doesn't exist", month));
    return MONTHS[month];
}
static void checkBoundaries(int n, int lowerBound, int upperBound, String errorMessage) {
    if (n < lowerBound || n > upperBound) {
        throw new IllegalArgumentException(errorMessage);
    }
}