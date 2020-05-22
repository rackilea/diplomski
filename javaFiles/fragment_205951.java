Timestamp timestamp = ...

//Convert to LocalDateTime. Use no offset for timezone
LocalDateTime time = LocalDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.ofHours(0));

//Add time. In this case, add one day.
time = time.plus(1, ChronoUnit.DAYS);

//Convert back to instant, again, no time zone offset.
Instant output = time.atZone(ZoneOffset.ofHours(0)).toInstant();

Timestamp savedTimestamp = Timestamp.from(output);