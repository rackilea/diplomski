final long timestamp = 1568124300000L;

// create an Instant from the timestamp
Instant instant = Instant.ofEpochMilli(timestamp);
// create a datetime object from the Instant
OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneId.of("UTC"));
// print it in your desired formatting
System.out.println("The day it belongs to is: "
                    + offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));