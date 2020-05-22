int separationCount = 0;
    LocalDate start = LocalDate.parse("2019-10-01");
    int dowNumber = 2;

    DayOfWeek dow = DayOfWeek.of(dowNumber);

    LocalDate first = start.with(TemporalAdjusters.nextOrSame(dow));
    System.out.println("first: " + first);
    LocalDate next = first.plusWeeks(1 + separationCount);
    System.out.println("next: " + next);