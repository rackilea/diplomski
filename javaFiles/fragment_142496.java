String inputTime = "20171025-10:58:24.062151";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm:ss.SSSSSS");
// parse to a LocalDateTime (keeping all date and time fields)
LocalDateTime date = LocalDateTime.parse(inputTime, formatter);
// convert to ZonedDateTime
ZonedDateTime z = date.atZone(ZoneId.systemDefault());