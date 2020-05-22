LocalDate start = LocalDate.parse("2019-10-01");
    int dowNumber = 1;
    int weekOfMonth = 3;

    DayOfWeek dow = DayOfWeek.of(dowNumber);

    LocalDate first = start.with(WeekFields.ISO.weekOfMonth(), weekOfMonth)
            .with(dow);
    if (first.isBefore(start)) {
        // Use next month instead
        first = start.plusMonths(1)
                .with(WeekFields.ISO.weekOfMonth(), weekOfMonth)
                .with(dow);
    }

    System.out.println("first: " + first);