// create a date 1 day before DST change in Sao Paulo, at 9 AM
ZoneId zone = ZoneId.of("America/Sao_Paulo");
ZonedDateTime z = ZonedDateTime.of(2017, 10, 14, 9, 0, 0, 0, zone);

// get the next day, at 9 AM
ZonedDateTime nextDay = z.plusDays(1);

System.out.println(z);
System.out.println(nextDay);