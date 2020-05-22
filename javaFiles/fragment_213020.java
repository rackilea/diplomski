static final String[] MONTHS = {"January", "February", ... };
static String getMonthName(int month) {
    if (month < 0 || month >= MONTHS.length) {
        throw new IllegalArgumentException(String.format("Month %d doesn't exist", month));
    }
    return MONTHS[month];
}