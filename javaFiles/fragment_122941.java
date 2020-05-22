// for reproducible results
System.setProperty("user.timezone", "Europe/Berlin");

LocalDate[] dates = {LocalDate.of(2037, 3, 29), LocalDate.of(2038, 3, 28)};
LocalTime[] time  = { LocalTime.of(0, 59, 59), LocalTime.of(1, 00, 01),
                      LocalTime.of(1, 59, 59), LocalTime.of(2, 00, 01) };
for(LocalDate localDate : dates) {
    for(LocalTime localTime1 : time) {
        ZonedDateTime zoned = LocalDateTime.of(localDate, localTime1)
                             .atZone(ZoneId.of("UTC"))
                             .withZoneSameInstant(ZoneId.systemDefault());
        System.out.println(zoned);
        System.out.println(new java.util.Date(zoned.toEpochSecond()*1000));
    }
    System.out.println();
}