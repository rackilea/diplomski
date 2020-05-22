// Decide what time zone you want to work in
ZoneId tz = ZoneId.of("Europe/Berlin");

// If you wanted the local time zone of the system,
// Use this instead:
// ZoneId tz = ZoneId.systemDefault();

// Get instants from the timestamps
Instant i1 = Instant.ofEpochMilli(1466062306000l);
Instant i2 = Instant.ofEpochMilli(1466028000000l);

// Get the calendar date in the specified time zone for each value
LocalDate d1 = i1.atZone(tz).toLocalDate();
LocalDate d2 = i2.atZone(tz).toLocalDate();

// Get the difference in days
long daysBetween = ChronoUnit.DAYS.between(d2, d1);