int offset = (int) TimeUnit.HOURS.toMillis(1);
String[] ids = TimeZone.getAvailableIDs(offset);
TimeZone cet = Arrays.stream(ids).map(TimeZone::getTimeZone)
    .filter(tz -> tz.getDisplayName(false, TimeZone.SHORT).equals("CET"))
    .findFirst().orElseThrow(
        () -> new RuntimeException("No CET timezone found"));

TimeZone.setDefault(cet);