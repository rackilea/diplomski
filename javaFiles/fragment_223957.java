long timestamp = 1_525_708_128_067L;
    LocalDateTime dateTimeInUnknownTimezone = LocalDateTime.of(2018, Month.MAY, 7, 18, 48, 48);

    LocalDateTime utcDateTime = Instant.ofEpochMilli(timestamp)
            .atOffset(ZoneOffset.UTC)
            .toLocalDateTime()
            .truncatedTo(ChronoUnit.SECONDS);

    int offsetInSeconds = (int) ChronoUnit.SECONDS.between(utcDateTime, dateTimeInUnknownTimezone);
    ZoneOffset offset = ZoneOffset.ofTotalSeconds(offsetInSeconds);
    System.out.println(offset);