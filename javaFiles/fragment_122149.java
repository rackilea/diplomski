long startTimeDateInLong = // long millis value
long endTimeDateInLong = // long millis value

// get the corresponding Instant
Instant start = Instant.ofEpochMilli(startTimeDateInLong);
Instant end = Instant.ofEpochMilli(endTimeDateInLong);

// get the difference in seconds
Duration duration = Duration.between(start, end);
long secs = duration.getSeconds();

// perform the same calculations as above (with BigDecimal)