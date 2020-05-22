DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
OffsetDateTime offsetDateTime = OffsetDateTime.parse("2018-12-24 12:00:00 +0800", formatter);
offsetDateTime = offsetDateTime.minusHours(12);
ZonedDateTime dateTimeInDesiredZoned = offsetDateTime.atZoneSameInstant(ZoneId.of("UTC"));
// 2018-12-23 16:00:00 +0000
System.out.println(formatter.format(dateTimeInDesiredZoned));