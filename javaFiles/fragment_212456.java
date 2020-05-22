// parse jsonInput
String jsonInput = "2017-06-22 02:03:03";
// formatter
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
// parse the input to a LocalDateTime
LocalDateTime dt = LocalDateTime.parse(jsonInput, fmt); // 2017-06-22T02:03:03
// convert it to the EDT timezone (using America/Chicago as it's currently in CDT)
ZonedDateTime z = dt.atZone(ZoneId.of("America/Chicago")); // 2017-06-22T02:03:03-05:00[America/Chicago]

// convert the java.util.Date object to the new API
Date date = new Date(1498111393000L); // using your timestamp = 2017-06-22T06:03:13 UTC
// for Java >= 8, use toInstant method
Instant instant = date.toInstant();
// for Java <= 7, use org.threeten.bp.DateTimeUtils
Instant instant = DateTimeUtils.toInstant(date);

// get the difference between them
long diffSecs = ChronoUnit.SECONDS.between(instant, z);