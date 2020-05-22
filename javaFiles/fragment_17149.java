long millis = 5007;
    long hours = TimeUnit.MILLISECONDS.toHours(millis);
    millis -= TimeUnit.HOURS.toMillis(hours);
    long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
    millis -= TimeUnit.MINUTES.toMillis(minutes);
    long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
    millis -= TimeUnit.SECONDS.toMillis(seconds);
    String hmss = String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, millis);