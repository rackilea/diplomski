final DateTimeFormatter timestampFormatter
            = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss");
    final ZoneId systemBTimeZone = ZoneId.of("America/New_York");
    final String syncFormatPattern = "'Sync''ed-as-of time:' EEE MMM d HH:mm";
    final DateTimeFormatter currentSystemBTiemFormatter = new DateTimeFormatterBuilder()
            .appendPattern("EEE MMM dd HH:mm:ss ")
            .appendZoneText(TextStyle.SHORT, Collections.singleton(systemBTimeZone))
            .appendPattern(" yyyy")
            .toFormatter(Locale.US);
    final Period maxSyncAge = Period.ofYears(2);

    String systemATimestampString = "2019-11-03-06-05-55";
    String lastSyncMsg = "Sync'ed-as-of time: Sun Nov 3 01:13";
    String currentSystemBTime = "Sun Nov 03 01:13:07 EDT 2019";
    OffsetDateTime systemATimestamp = LocalDateTime.parse(systemATimestampString, timestampFormatter)
            .atOffset(ZoneOffset.UTC);
    ZonedDateTime maxLastSyncTime
            = ZonedDateTime.parse(currentSystemBTime, currentSystemBTiemFormatter);
    ZonedDateTime minLatSyncTime = maxLastSyncTime.minus(maxSyncAge);
    int candidateYear = maxLastSyncTime.getYear();
    ZonedDateTime syncTime;
    while (true) {
        DateTimeFormatter syncFormatter = new DateTimeFormatterBuilder()
                .appendPattern(syncFormatPattern)
                .parseDefaulting(ChronoField.YEAR, candidateYear)
                .toFormatter(Locale.US);
        try {
            syncTime = LocalDateTime.parse(lastSyncMsg, syncFormatter)
                    .atZone(systemBTimeZone)
                    .withEarlierOffsetAtOverlap();
            if (syncTime.isBefore(minLatSyncTime) || syncTime.isAfter(maxLastSyncTime)) {
                throw new IllegalStateException("Last sync time is out of range");
            }
            break;
        } catch (DateTimeParseException dtpe) {
            // Ignore; try next earlier year
        }
        candidateYear--;
    }
    System.out.println("Last sync time: " + syncTime);
    System.out.println("Timestamp from system A: " + systemATimestamp);
    System.out.println("Is OK? " + syncTime.toOffsetDateTime().isAfter(systemATimestamp));