// Convert to Joda-Time.
DateTimeZone timeZone = DateTimeZone.forID( "Europe/Paris" );
org.joda.time.DateTime dateTime = new DateTime( fileTimeCreation.toMillis(), timeZone );

// Convert to java.time.* package in Java 8.
ZoneId zoneId = ZoneId.of( "Europe/Paris" );
ZonedDateTime zonedDateTime = ZonedDateTime.parse( fileTimeCreation.toString() ).withZoneSameInstant( zoneId );

// Convert to java.util.Date
// Caution: I do not recommend using java.util.Date & Calendar classes. But if you insist…
java.util.Date date = new java.util.Date( fileTimeCreation.toMillis() );