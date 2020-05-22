public static LocalDate getDate(String input) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.M.yyyy");
    LocalDate now = LocalDate.now();
    boolean is29 = input.equals("29.2");

    LocalDate date = LocalDate.parse(String.format("%s.%d", input, now.get(ChronoField.YEAR)), dtf);

    if (date.compareTo(now) > 0) {
        date = date.minusYears(1);
    }

    if (is29 && !date.isLeapYear()) {
        do {
            date = date.minusYears(1);
        } while (!date.isLeapYear());
        date = date.plusDays(1); //move from 28th to 29th
    }

    return date;
}