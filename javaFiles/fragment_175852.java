public static String timeBetween(Date start, Date end) {
    long timeDiff = Math.abs(end.getTime() - start.getTime());
    String diff = String.format("in days: %d | in hours: %d | in minutes: %d",
        TimeUnit.MILLISECONDS.toDays(timeDiff),
        TimeUnit.MILLISECONDS.toHours(timeDiff),
        TimeUnit.MILLISECONDS.toMinutes(timeDiff));
    return diff;
}