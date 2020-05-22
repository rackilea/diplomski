public static void main(String[] args) {
    // create a time object from the String
    LocalTime localTime = LocalTime.parse("06:00", DateTimeFormatter.ofPattern("HH:mm"));
    // print it once in an ISO format
    System.out.println(localTime.format(DateTimeFormatter.ISO_TIME));
    // receive the date of today
    LocalDate today = LocalDate.now();
    // then use the date and the time object to create a zone-aware datetime object
    ZonedDateTime zdt = LocalDateTime.of(today, localTime).atZone(ZoneId.of("UTC"));
    // print it
    System.out.println(zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
}