LocalDate ld = LocalDate.now();
LocalDate sunday = ld.minusDays(ld.getDayOfWeek().getValue());
LocalDate tommorrow = ld.plusDays(1);
LocalDate date = sunday;
while (date.isBefore(tommorrow)) {
    System.out.println(date);
    date = date.plusDays(1);
}