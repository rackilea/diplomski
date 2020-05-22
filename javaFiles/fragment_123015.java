private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

public static String convertTime(String inputTime) {
    ZoneId destinationTimeZone = ZoneId.of("Asia/Riyadh");
    return LocalDateTime.parse(inputTime, formatter)
            .atOffset(ZoneOffset.UTC)
            .atZoneSameInstant(destinationTimeZone)
            .format(formatter);
}