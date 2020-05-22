public static class ISO8601DateFormat extends DateFormat {
    ...

    // MUST make dateFormat reusable.
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    public void setTimeZone(TimeZone zone)
    {
        dateFormat.setTimeZone(zone);
    }
}