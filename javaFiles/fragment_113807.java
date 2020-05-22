Date parsed;
try {
    SimpleDateFormat format =
        new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    parsed = format.parse(dateString);
}
catch(ParseException pe) {
    throw new IllegalArgumentException(pe);
}