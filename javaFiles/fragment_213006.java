public static LocalDateTime getLastFriday(LocalDateTime anchor) {
    LocalDateTime ldt = LocalDateTime.from(anchor);
    return ldt.with(DayOfWeek.FRIDAY).withHour(17).withMinute(42).withSecond(0).withNano(0);
}

public static LocalDateTime getNextSunday(LocalDateTime anchor) {
    LocalDateTime ldt = LocalDateTime.from(anchor);
    return ldt.with(DayOfWeek.SUNDAY).withHour(17).withMinute(42).withSecond(0).withNano(0);
}