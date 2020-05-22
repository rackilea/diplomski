//Parse string into local date. LocalDateTime has no timezone component
LocalDateTime time = LocalDateTime.parse("2014-04-16T13:00:00");

//Convert to Instant with no time zone offset
Instant instant = time.atZone(ZoneOffset.ofHours(0)).toInstant();

//Easy conversion from Instant to the java.sql.Timestamp object
Timestamp timestamp = Timestamp.from(instant);