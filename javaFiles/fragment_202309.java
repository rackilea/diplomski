System.out.println(LocalDateTime.parse(
            "19940513230000",
            new DateTimeFormatterBuilder()
                .appendPattern("[uuuuMMddHHmmss][uuuuMMdd]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0) 
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)         
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter()
        ));