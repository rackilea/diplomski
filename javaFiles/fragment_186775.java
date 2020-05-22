static final DateTimeFormatter DATE_TIME_FORMATTER = 
        new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(' ')
                .appendPattern("HH:mm:ss")
                .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
                .toFormatter();