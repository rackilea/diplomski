public LocalDate getDate(String input) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.M.yyyy");
    LocalDate now = LocalDate.now();

    LocalDate date = LocalDate.parse(String.format("%s.%d", input, now.get(ChronoField.YEAR)), dtf);

    if (date.compareTo(now) > 0) {
        date = date.minusYears(1);
    }
    return date;
}