DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
ZonedDateTime zdt = LocalDateTime
    // parse date/time String
    .parse(input, fmt)
    // set to a timezone (for UTC, use ZoneOffset.UTC)
    .atZone(ZoneId.of("America/New_York"));

// difference in milliseconds
long diffFromNow = ChronoUnit.MILLIS.between(Instant.now(), zdt.toInstant());