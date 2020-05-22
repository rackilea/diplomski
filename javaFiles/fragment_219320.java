String startAt = "15-05-15 02:00:AM";
String endAt = "15-05-15 06:00:AM";

String format = "dd-MM-yy hh:mm':'a";

LocalDateTime startTime = LocalDateTime.parse(startAt, DateTimeFormatter.ofPattern(format));
LocalDateTime endTime = LocalDateTime.parse(endAt, DateTimeFormatter.ofPattern(format));
while (endTime.isAfter(startTime)) {
    LocalDateTime next = startTime.plusMinutes(60);
    System.out.println("StartTime : " + startTime.format(DateTimeFormatter.ofPattern(format)) + "; End Time : " + next.format(DateTimeFormatter.ofPattern(format)));
    startTime = next;
}