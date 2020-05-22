/** Map of letters to fields. */
private static final Map<Character, TemporalField> FIELD_MAP = new HashMap<>();
static {
    // SDF = SimpleDateFormat
    FIELD_MAP.put('G', ChronoField.ERA);                       // SDF, LDML (different to both for 1/2 chars)
    FIELD_MAP.put('y', ChronoField.YEAR_OF_ERA);               // SDF, LDML
    FIELD_MAP.put('u', ChronoField.YEAR);                      // LDML (different in SDF)
    FIELD_MAP.put('Q', IsoFields.QUARTER_OF_YEAR);             // LDML (removed quarter from 310)
    FIELD_MAP.put('q', IsoFields.QUARTER_OF_YEAR);             // LDML (stand-alone)
    FIELD_MAP.put('M', ChronoField.MONTH_OF_YEAR);             // SDF, LDML
    FIELD_MAP.put('L', ChronoField.MONTH_OF_YEAR);             // SDF, LDML (stand-alone)
    FIELD_MAP.put('D', ChronoField.DAY_OF_YEAR);               // SDF, LDML
    FIELD_MAP.put('d', ChronoField.DAY_OF_MONTH);              // SDF, LDML
    FIELD_MAP.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);  // SDF, LDML
    FIELD_MAP.put('E', ChronoField.DAY_OF_WEEK);               // SDF, LDML (different to both for 1/2 chars)
    FIELD_MAP.put('c', ChronoField.DAY_OF_WEEK);               // LDML (stand-alone)
    FIELD_MAP.put('e', ChronoField.DAY_OF_WEEK);               // LDML (needs localized week number)
    FIELD_MAP.put('a', ChronoField.AMPM_OF_DAY);               // SDF, LDML
    FIELD_MAP.put('H', ChronoField.HOUR_OF_DAY);               // SDF, LDML
    FIELD_MAP.put('k', ChronoField.CLOCK_HOUR_OF_DAY);         // SDF, LDML
    FIELD_MAP.put('K', ChronoField.HOUR_OF_AMPM);              // SDF, LDML
    FIELD_MAP.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);        // SDF, LDML
    FIELD_MAP.put('m', ChronoField.MINUTE_OF_HOUR);            // SDF, LDML
    FIELD_MAP.put('s', ChronoField.SECOND_OF_MINUTE);          // SDF, LDML
    FIELD_MAP.put('S', ChronoField.NANO_OF_SECOND);            // LDML (SDF uses milli-of-second number)
    FIELD_MAP.put('A', ChronoField.MILLI_OF_DAY);              // LDML
    FIELD_MAP.put('n', ChronoField.NANO_OF_SECOND);            // 310 (proposed for LDML)
    FIELD_MAP.put('N', ChronoField.NANO_OF_DAY);               // 310 (proposed for LDML)
}