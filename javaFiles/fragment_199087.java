long testDateLong = 1564451599000L;
Instant ist = Instant.ofEpochMilli(testDateLong);

ZoneId zUTC = ZoneId.of("UTC");
ZoneId zLA = ZoneId.of("America/Los_Angeles");

ZonedDateTime zdt1 = LocalDateTime.ofInstant(ist, zUTC).atZone(zLA);
ZonedDateTime zdt2 = ZonedDateTime.ofInstant(ist, zUTC).withZoneSameLocal(zLA);

System.out.println(zdt1); // 2019-07-30T01:53:19-07:00[America/Los_Angeles]
System.out.println(zdt2); // 2019-07-30T01:53:19-07:00[America/Los_Angeles]