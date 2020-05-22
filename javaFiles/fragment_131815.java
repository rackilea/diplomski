public static String convert(String originalTime) {
    LocalDate localDate;

    if (originalTime.contains("T")) {
        localDate = OffsetDateTime.parse(originalTime).toLocalDate();
    } else {
        localDate = LocalDate.parse(originalTime);
    }

    return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
}