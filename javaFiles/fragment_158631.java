LocalDate firstMonday = LocalDate.of(yearSince, 1, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
 EnumMap<Month, Integer> right =
        Stream.iterate(firstMonday, date -> date.plusWeeks(1))
              .takeWhile(date -> date.getYear() <= yearUntilInclusive)
              .collect(
                  Collectors.collectingAndThen(
                      Collectors.groupingBy(LocalDate::getMonth, Collectors.summingInt(x -> 1)),
                      EnumMap::new
                  )
              );