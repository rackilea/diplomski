private static final DateTimeFormatter FORMAT_TIMESTAMP =
                                      DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ");

public static String format(Instant timestamp) {
    return FORMAT_TIMESTAMP.print(timestamp);
}