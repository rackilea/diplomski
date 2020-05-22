LocalDate start = LocalDate.of(2015, 2, 1);
LocalDate end = LocalDate.of(2015, 2, 28);

List<DayOfWeek> includedDays = Arrays.asList(DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

long daysCount = Stream.iterate(start, date -> date.plusDays(1))
        .limit(ChronoUnit.DAYS.between(start, end))
        .filter(d -> includedDays.contains(d.getDayOfWeek()))
        .count();