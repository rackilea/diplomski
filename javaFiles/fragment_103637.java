static LocalDate dateFromId(int id) {
    int year = id / 10000;
    int month = (id / 100) % 100;
    int day = id % 100;
    return LocalDate.of(year, month, day);
}

static int idFromDate(LocalDate date) {
    return date.getYear * 10000
        + date.getMonthValue() * 100 
        + date.getDayOfMonth();
}

static int advanceId(int id, int days) {
    LocalDate original = dateFromId(id);
    LocalDate advanced = original.plusDays(days);
    return idFromDate(advanced);
}