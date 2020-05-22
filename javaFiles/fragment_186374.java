public class JulianDay {
    private static final double NANOS_PER_DAY = 24.0 * 60.0 * 60.0 * 1000000000.0;

    // Calculate Instants for some epochs as defined in Wikipedia.
    public static final Instant REDUCED_JD =
            ZonedDateTime.of(1858, 11, 16, 12, 0, 0, 0, ZoneOffset.UTC).toInstant();
    public static final Instant MODIFIED_JD =
            ZonedDateTime.of(1858, 11, 17, 0, 0, 0, 0, ZoneOffset.UTC).toInstant();
    public static final Instant JULIAN_DATE =
            REDUCED_JD.minus(2400000, ChronoUnit.DAYS);

    private final Instant epoch;

    public JulianDay(Instant epoch) {
        super();
        this.epoch = epoch;
    }

    public Instant toInstant(double day) {
        long l = (long) day;
        return epoch
                .plus(l, ChronoUnit.DAYS)
                .plusNanos(Math.round((day - l) * NANOS_PER_DAY));
    }

    public static void main(String[] args) {
        // Use the example values from Wikipedia for 2015-09-07 13:21 UTC.
        System.out.println(new JulianDay(REDUCED_JD).toInstant(57273.05625));
        // Output: 2015-09-07T13:21:00.000000126Z
        System.out.println(new JulianDay(MODIFIED_JD).toInstant(57272.55625));
        // Output: 2015-09-07T13:21:00.000000126Z
        System.out.println(new JulianDay(JULIAN_DATE).toInstant(2457273.05625));
        // Output: 2015-09-07T13:20:59.999991953Z
    }
}