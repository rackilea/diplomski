Function<String, Range> convertToRange = (dateString) -> {

    String[] dateStringParts = dateString.split("/");
    return new Range(LocalDateTime.parse(dateStringParts[0], DateTimeFormatter.ISO_DATE_TIME),
            LocalDateTime.parse(dateStringParts[1], DateTimeFormatter.ISO_DATE_TIME));
};

Function<String, DurationAndDateTime> convertToDurationAndDateTime = (dateString) -> {
    String[] dateStringParts = dateString.split("/");
    String[] durationAndPeriodParts = dateStringParts[1].split("T");
    return new DurationAndDateTime(Period.parse(durationAndPeriodParts[0]),
            Duration.parse("PT" + durationAndPeriodParts[1]),
            LocalDateTime.parse(dateStringParts[0], DateTimeFormatter.ISO_DATE_TIME));
};


Function<String, DurationAndDateTime> convertToDateTimeAndDuration = (dateString) -> {
    String[] dateStringParts = dateString.split("/");
    String[] durationAndPeriodParts = dateStringParts[0].split("T");
    return new DurationAndDateTime(Period.parse(durationAndPeriodParts[0]),
            Duration.parse("PT" + durationAndPeriodParts[1]),
            LocalDateTime.parse(dateStringParts[1], DateTimeFormatter.ISO_DATE_TIME));
};

Function<String, DurationOnly> convertToDurationOnlyRelativeToCurrentTime = (dateString) -> {
    String[] durationAndPeriodParts = dateString.split("T");
    return new DurationOnly(Period.parse(durationAndPeriodParts[0]),
            Duration.parse("PT" + durationAndPeriodParts[1]));
};