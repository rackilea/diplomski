String inputStart = "2017-01-23 05:25:00".replace ( " " , "T" );
String inputStop = "2018-03-20 07:29:50".replace ( " " , "T" );

LocalDateTime ldtStart = LocalDateTime.parse ( inputStart ); // LocalDateTime used only briefly here, to parse inputs. Then we switch to `ZonedDateTime`.
LocalDateTime ldtStop = LocalDateTime.parse ( inputStop );

ZoneId z = ZoneId.of( "America/Montreal" );
ZonedDateTime zdtStart = ldtStart.atZone( z ); // Invalid values may be adjusted, such as during the hour of a "Spring-forward" Daylight Saving Time (DST) switch-over.
ZonedDateTime zdtStop = ldtStop.atZone( z );

Period p = Period.between ( zdtStart.toLocalDate () , zdtStop.toLocalDate () ).minusDays ( 1 );  // Subtract one, as we account for hours of first day.

// Get the Duration of first day's hours-minutes-seconds.
ZonedDateTime zdtStartNextDay = zdtStart.toLocalDate ().plusDays ( 1 ).atStartOfDay ( z );
Duration dStart = Duration.between ( zdtStart , zdtStartNextDay );

// Get the Duration of first day's hours-minutes-seconds.
ZonedDateTime zdtStopStartOfDay = zdtStop.toLocalDate ().atStartOfDay ( z );
Duration dStop = Duration.between ( zdtStopStartOfDay , zdtStop );

// Combine the pair of partial days into a single Duration.
Duration d = dStart.plus ( dStop );

System.out.println ( "zdtStart: " + zdtStart );
System.out.println ( "zdtStop: " + zdtStop );
System.out.println ( "p: " + p );
System.out.println ( "dStart: " + dStart + " and dStop: " + dStop );
System.out.println ( "d: " + d );

int years = p.getYears ();
int months = p.getMonths ();
int days = p.getDays ();
System.out.println( "Years: " + years + "\nMonths: " + months + "\nDays: " + days );

// Enable if in Java 9 or later (but not in Java 8)
// long durationDays = d.toDaysPart();
// long hours = d.toHoursPart();
// long minutes = d.toMinutesPart();
// long seconds = d.toSecondsPart();
// int nanos = d.toNanosPart();