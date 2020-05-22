LocalDateTime now = new LocalDateTime();
LocalDateTime then = now.minusDays(2).minusMinutes(5);
int numberOfDaysBetween = Days.daysBetween(then, now).getDays();
LocalDateTime fullDayTime = then.plusDays(numberOfDaysBetween);
if (fullDayTime.isBefore(now)) {
    numberOfDaysBetween++;
}