DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("MMM dd HH:mm:ss")
            .parseDefaulting(ChronoField.YEAR, 1)
            .toFormatter();

LocalDateTime date = LocalDateTime.parse(rebootTime, formatter);