DateTimeFormatter dtf =
    DateTimeFormatter.ISO_INSTANT;
TemporalAccessor raw = dtf.parse("2016-12-31T23:59:60Z");
Instant instant = Instant.from(raw);
System.out.println(
    instant
    + " (leap-second-parsed=" + raw.query(DateTimeFormatter.parsedLeapSecond()) + ")");
// 2016-12-31T23:59:59Z (leap-second-parsed=true)