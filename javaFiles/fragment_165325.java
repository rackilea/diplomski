LocalDate now = LocalDate.now();
LocalDate sunday = now.minusDays(5).withDayOfWeek(DateTimeConstants.SUNDAY);
LocalDate tommorrow = now.plusDays(1);
LocalDate date = sunday;
while (date.isBefore(tommorrow)) {
    System.out.println(date);
    date = date.plusDays(1);
}