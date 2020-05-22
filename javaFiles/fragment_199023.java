public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
    int dowValue = dayOfWeek.getValue();
    return (temporal) -> {
        int calDow = temporal.get(DAY_OF_WEEK);
        if (calDow == dowValue) {
            return temporal;  // <-- returns the original object!
        }
        int daysDiff = calDow - dowValue;
        return temporal.plus(daysDiff >= 0 ? 7 - daysDiff : -daysDiff, DAYS);
    };
}