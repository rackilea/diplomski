ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Eastern"));
ZonedDateTime target2 = zdt
    .withHour(15)
    .withMinute(0)
    .withSecond(0)
    .withNano(0);

if (target2.isBefore(zdt)) {
  zdt = zdt.plusDays(1);
}

System.out.println(zdt.until(target2, ChronoUnit.MILLIS));