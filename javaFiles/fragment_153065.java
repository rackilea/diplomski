private static final LocalTime START = LocalTime.of(18, 0);
private static final LocalTime END = LocalTime.of(8, 0);

public static Duration overlap(ZonedDateTime currentStart, ZonedDateTime currentEnd) {
    ZonedDateTime singleIntervalStart = currentStart.with(START);
    ZonedDateTime singleIntervalEnd = currentStart.plusDays(1).with(END);
    if (currentEnd.isBefore(singleIntervalStart)) {
        // no overlap
        return Duration.ZERO;
    }
    ZonedDateTime overlapStart = currentStart.isBefore(singleIntervalStart)
            ? singleIntervalStart : currentStart;
    ZonedDateTime overlapEnd = currentEnd.isBefore(singleIntervalEnd)
            ? currentEnd : singleIntervalEnd;
    return Duration.between(overlapStart, overlapEnd);
}