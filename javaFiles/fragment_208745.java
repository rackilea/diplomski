DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendValue(WeekFields.ISO.weekBasedYear(), 4)
            .appendValue(WeekFields.ISO.weekOfWeekBasedYear(), 2)
            .parseDefaulting(WeekFields.ISO.dayOfWeek(), DayOfWeek.SUNDAY.getValue())
            .toFormatter();

    System.out.println(LocalDate.parse("201901", formatter));