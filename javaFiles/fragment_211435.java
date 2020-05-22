public static void main(String[] args) {
    String time1Str = "22:00";
    String time2Str = "01:00";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time1 = LocalTime.parse(time1Str, formatter);
    LocalTime time2 = LocalTime.parse(time2Str, formatter);

    // add date value: start with today
    LocalDate today = LocalDate.now();
    // combine date time for lower value: will be assigned to today
    LocalDateTime dateTime1 = LocalDateTime.of(today, time1);
    // combine date time for upper value: will be assigned same day if it is after lower value
    // otherwise (we crossed date boundary) assign it to tomorrow
    LocalDateTime dateTime2 =   time2.isAfter(time1) ?
            LocalDateTime.of(today, time2) : LocalDateTime.of(today.plusDays(1), time2);

    Duration duration = Duration.between(dateTime1, dateTime2);
    Duration halfDuration = duration.dividedBy(2);
    LocalTime result = LocalTime.from(halfDuration.addTo(time1));

    System.out.println(result.format(formatter));
}