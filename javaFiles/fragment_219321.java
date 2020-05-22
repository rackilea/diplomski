String startAt = "15-05-15 02:00:AM";
String endAt = "15-05-15 06:00:AM";

String format = "dd-MM-yy hh:mm':'a";
DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

LocalDateTime startTime = formatter.parseLocalDateTime(startAt);
LocalDateTime endTime = formatter.parseLocalDateTime(endAt);

while (endTime.isAfter(startTime)) {
    LocalDateTime next = startTime.plusMinutes(60);
    System.out.println("StartTime : " + formatter.print(startTime) + "; End Time : " + formatter.print(next));
    startTime = next;
}