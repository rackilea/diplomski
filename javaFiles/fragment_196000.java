private final static SimpleDateFormat DATE_FORMAT = createFormat();

private static SimpleDateFormat createFormat() {
    // Make sure there are no locale-specific nasties, either...
    SimpleDateFormat ret = new SimpleDateFormat("yyyy.MM.dd'T'HH:mm.ss:SSSZZ",
                                                Locale.US);
    ret.setTimeZone(TimeZone.getTimeZone("Etc/UTC");
}