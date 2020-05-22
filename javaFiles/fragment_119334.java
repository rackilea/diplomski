public static LocalDate getNearestDayOfWeek(LocalDate t0, int dow) {
    LocalDate t1 = t0.withDayOfWeek(dow);
    if (t1.isBefore(t0.minusDays(3)))       return t1.plusWeeks(1);
    else if (t1.isAfter(t0.plusDays(3)))    return t1.minusWeeks(1);
    else return t1;
}