String timeStr = "30";
    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                .append(DateTimeFormatter.ofPattern("mm"))
                                .parseDefaulting(ChronoField.HOUR_OF_DAY,0)
                                .toFormatter();
    LocalTime parsedTime = LocalTime.parse(timeStr, formatter);