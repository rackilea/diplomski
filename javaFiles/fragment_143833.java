LocalTime startT = LocalTime.of(6,30);
LocalTime endT = LocalTime.of(12,15);

long minutes = ChronoUnit.MINUTES.between(startT, endT);

System.out.println(minutes); // output: 345

// Answer to a recommendation in a comment:
// Attention JSR-310 has no typesafety regarding units (a bad design choice)
// => UnsupportedTemporalTypeException: Unsupported unit: Minutes
minutes = Duration.between(startT, endT).get(ChronoUnit.MINUTES);