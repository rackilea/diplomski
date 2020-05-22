public static EnumMap<Month, Integer> totalMondaysByMonth(int yearSince, int yearUntilInclusive) {

    return Stream.iterate(LocalDate.of(yearSince, 1, 1), date -> date.plusDays(1))
                 .takeWhile(date -> date.getYear() <= yearUntilInclusive)
                 .filter(x -> x.getDayOfWeek() == DayOfWeek.MONDAY)
                 .collect(
                     Collectors.collectingAndThen(
                         Collectors.groupingBy(LocalDate::getMonth, Collectors.summingInt(x -> 1)),
                         EnumMap::new
                     )
                 );
}