DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("YYYY-'W'ww")
            .parseDefaulting(WeekFields.ISO.dayOfWeek(), DayOfWeek.SUNDAY.getValue())
            .toFormatter();

    System.out.println(LocalDate.parse("2019-W01", formatter));