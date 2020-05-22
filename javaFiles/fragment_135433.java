Map<Long, String> monthNameMap = new HashMap<>();
map.put(1L, "Jan.");
map.put(2L, "Feb.");
map.put(3L, "Mar.");
DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    .appendPattern("d. ")
    .appendText(ChronoField.MONTH_OF_YEAR, monthNameMap)
    .appendPattern(" HH:mm")
    .parseDefaulting(ChronoField.YEAR, 2016)
    .toFormatter();

System.out.println(LocalDateTime.parse("10. Jan. 18:14", fmt));
System.out.println(LocalDateTime.parse("8. Feb. 19:02", fmt));