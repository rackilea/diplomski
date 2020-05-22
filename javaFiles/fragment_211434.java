public static void main(String[] args) {
    String time1Str = "04:00";
    String time2Str = "09:00";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time1 = LocalTime.parse(time1Str, formatter);
    LocalTime time2 = LocalTime.parse(time2Str, formatter);
    Duration duration = Duration.between(time1, time2);  // 9-4
    Duration halfDuration = duration.dividedBy(2);  // divided by 2
    LocalTime result = LocalTime.from(halfDuration.addTo(time1));  // added to start time

    System.out.println(result.format(formatter));
}