LocalDateTime start = LocalDateTime.now();
    // Hour + 1, set Minute and Second to 00
    LocalDateTime end = start.plusHours(1).truncatedTo(ChronoUnit.HOURS);

    // Get Duration
    Duration duration = Duration.between(start, end);
    long millis = duration.toMillis();