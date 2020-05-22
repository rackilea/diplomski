protected static int between(ReadableInstant start, ReadableInstant end, DurationFieldType field) {
    if (start == null || end == null) {
        throw new IllegalArgumentException("ReadableInstant objects must not be null");
    }
    Chronology chrono = DateTimeUtils.getInstantChronology(start);
    int amount = field.getField(chrono).getDifference(end.getMillis(), start.getMillis());
    return amount;
}