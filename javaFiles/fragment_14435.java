public static final long PST_1970; static {
    try {
        final SimpleDateFormat MM_DD_YYYY = new SimpleDateFormat("MM/dd/yyyy");
        MM_DD_YYYY.setTimeZone(TimeZone.getTimeZone("PST"));
        PST_1970 = MM_DD_YYYY.parse("01/01/1970").getTime();
    } catch (ParseException e) {
        throw new AssertionError(e);
    }
}

public static void main(String... args) throws InterruptedException {
    long now = System.currentTimeMillis();
    long timeSincePST = now - PST_1970;
    System.out.println("now since 1970 GMT " + now);
    System.out.println("millis since 1970 PST " + timeSincePST);
}