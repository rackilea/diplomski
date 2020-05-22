private static final String defaultHours = "-1";

public static String calculateTotalHours(Cell inTime, Cell outTime, Cell breakStart, Cell breakEnd)
{
    try {
        LocalTime inLocalTime = LocalTime.parse(inTime.getStringCellValue());
        LocalTime outLocalTime = LocalTime.parse(outTime.getStringCellValue());
        LocalTime breakStartTime = LocalTime.parse(breakStart.getStringCellValue());
        LocalTime breakEndTime = LocalTime.parse(breakEnd.getStringCellValue());

        Duration lunch = Duration.between(breakStartTime, breakEndTime);
        Duration present = Duration.between(inLocalTime, outLocalTime);
        Duration worked = present.minus(lunch);

        return String.format("%02d:%02d", worked.toHours(), worked.toMinutesPart());

    } catch (DateTimeParseException dtpe) {
        System.out.println(dtpe);
        return defaultHours;
    }
}