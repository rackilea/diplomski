final LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
final LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

final int days = (int) start.until(end, ChronoUnit.DAYS);

return Stream.iterate(start, d -> d.plusDays(1))
  .limit(days)
  .collect(Collectors.toList());