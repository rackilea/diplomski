// with LocalDateTime startDate and LocalDateTime endDate defined,
LocalDateTime currentRangeStart = startDate;
while (currentRangeStart.isBefore(endDate)) {
    LocalDateTime nextHour = currentRangeStart.withMinute(0).plusHours(1);
    LocalDateTime currentRangeEnd = nextHour.isBefore(endDate) ? nextHour : endDate;
    System.out.printf("%s - %s%n", currentRangeStart, currentRangeEnd);
    currentRangeStart = currentRangeEnd;
}