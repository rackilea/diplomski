LocalTime start = LocalTime.parse("23:50");
LocalTime end = LocalTime.parse("00:10");
// calculate duration
Duration d;
if (start.isAfter(end)) {
    // start is after end, it means end is in the next day

    // current date
    LocalDate now = LocalDate.now();
    // start is at the current day
    LocalDateTime startDt = now.atTime(start);
    // end is at the next day
    LocalDateTime endDt = now.plusDays(1).atTime(end);
    d = Duration.between(startDt, endDt);
} else {
    // both start and end are in the same day
    // just calculate the duration in the usual way
    d = Duration.between(start, end);
}