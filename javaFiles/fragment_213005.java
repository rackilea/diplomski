LocalDateTime now = LocalDateTime.now();
boolean isBetween = false;
switch (now.getDayOfWeek()) {
    case FRIDAY:
    case SATURDAY:
    case SUNDAY:
        LocalDateTime lastFriday = getLastFriday(now);
        LocalDateTime nextSunday = getNextSunday(now);
        isBetween = isBetween(now, lastFriday, nextSunday);
        System.out.println(lastFriday + " - " + nextSunday + ": " + end);
        break;
}