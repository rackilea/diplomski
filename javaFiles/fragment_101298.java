import java.sql.Date;

// …

    // Modern ID of the time zone previously known as US/Eastern
    ZoneId datebaseTimeZone = ZoneId.of("America/New_York");

    Date dateFromDatabase = new Date(TimeUnit.SECONDS.toMillis(1_550_034_000));
    System.out.println("Date as retrieved from database (or pretending): " + dateFromDatabase);

    long epochMillis = dateFromDatabase.getTime();
    ZonedDateTime dateTime = Instant.ofEpochMilli(epochMillis)
            .atZone(datebaseTimeZone);
    LocalDate realDate = dateTime.toLocalDate();
    // Sanity check
    if (! realDate.atStartOfDay(datebaseTimeZone).equals(dateTime)) {
        throw new IllegalStateException("Failed to convert date correctly from " + datebaseTimeZone + " time zone");
    }

    System.out.println("Date is " + realDate);