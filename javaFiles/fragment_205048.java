Instant instant1 = Instant.parse("2019-02-14T18:42:00Z");
Instant instant2 = Instant.parse("2019-04-21T05:25:00Z");

// If you only need one of them
System.out.println(ChronoUnit.DAYS.between(instant1, instant2));    // prints: 65
System.out.println(ChronoUnit.HOURS.between(instant1, instant2));   // prints: 1570
System.out.println(ChronoUnit.MINUTES.between(instant1, instant2)); // prints: 94243

// Or use alternate syntax (it's the same thing)
System.out.println(instant1.until(instant2, ChronoUnit.DAYS));    // prints: 65
System.out.println(instant1.until(instant2, ChronoUnit.HOURS));   // prints: 1570
System.out.println(instant1.until(instant2, ChronoUnit.MINUTES)); // prints: 94243

// Or use Duration
Duration duration = Duration.between(instant1, instant2);
System.out.println(duration.toDays());    // prints: 65
System.out.println(duration.toHours());   // prints: 1570
System.out.println(duration.toMinutes()); // prints: 94243

// In Java 9+, Duration can give them as parts to be used together
System.out.println(duration.toDaysPart());    // prints: 65
System.out.println(duration.toHoursPart());   // prints: 10
System.out.println(duration.toMinutesPart()); // prints: 43

// Or you can calculate the parts yourself, using epoch seconds
long seconds = instant2.getEpochSecond() - instant1.getEpochSecond();
System.out.println(seconds / 86400);     // prints: 65
System.out.println(seconds / 3600 % 24); // prints: 10
System.out.println(seconds / 60 % 60);   // prints: 43