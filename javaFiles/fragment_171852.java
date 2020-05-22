LocalDateTime datetime = LocalDateTime.of(2016, 6, 7, 8, 1, 55);
ZonedDateTime zdt = datetime.atZone(ZoneId.of("Europe/Berlin"));
Instant instant = zdt.toInstant();

Timestamp ts = Timestamp.from(instant); //The timestamp you describe in your question

ZonedDateTime result = ZonedDateTime.ofInstant(ts.toInstant(), ZoneId.of("Europe/Berlin"));

System.out.println(result); //WILL ALWAYS PRINTS: 2016-06-07T08:01:55+02:00[Europe/Berlin]