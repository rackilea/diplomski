DateTimeFormatter dtf =
    DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssXXX").withResolverStyle(ResolverStyle.SMART);
TemporalAccessor raw = dtf.parse("2016-12-31T23:59:60Z");
Instant instant = Instant.from(raw);
System.out.println(
    instant 
    + " (leap-second-parsed=" + raw.query(DateTimeFormatter.parsedLeapSecond()) + ")");