String time1 = "09:00"; //my first input time

String timeEnds = "04:00"; //my second input time
LocalTime timeStart = LocalTime.parse(time1);
LocalTime timeEnd = LocalTime.parse(timeEnds);
if (timeStart.isAfter(timeEnd)) {
    timeEnd = timeEnd.plusHours(12);
}

while(timeStart.isBefore(timeEnd)) {
    timeStart = timeStart.plusMinutes(30);
    System.out.println(timeStart.format(DateTimeFormatter.ofPattern("hh:mm")));

}