DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("y-M-d H:m:s");
LocalDateTime m1 = LocalDateTime.parse("2011-01-11 01:51:10", formatter1);
ZonedDateTime z1 = m1.atZone(ZoneId.of("UTC"));
ZonedDateTime z2 = z1.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

System.out.println(z2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));