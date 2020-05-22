DateTimeFormatter fmt = new DateTimeFormatterBuilder()
        .append(DateTimeFormatter.ISO_LOCAL_TIME)
        .parseDefaulting(ChronoField.EPOCH_DAY, 0)
        .toFormatter();
LocalDateTime dateTime = LocalDateTime.parse("18:14:00", fmt);

System.out.println(dateTime); // Prints: 1970-01-01T18:14