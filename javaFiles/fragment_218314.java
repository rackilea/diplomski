static long hundredNanosUntil(Instant begin, Instant end) {
    long secsDiff = Math.subtractExact(end.getEpochSecond(), begin.getEpochSecond());
    long totalHundredNanos = Math.multiplyExact(secsDiff, 10_000_000);
    return Math.addExact(totalHundredNanos, (end.getNano() - begin.getNano()) / 100);
}

static final Instant dotNetEpoch = ZonedDateTime.of(1, 1, 1, 0, 0, 0, 0,
                                               ZoneOffset.UTC).toInstant();

static long toDotNetDateTimeTicks(Instant i) {
    return hundredNanosUntil(dotNetEpoch, i);
}