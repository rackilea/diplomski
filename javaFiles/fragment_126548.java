public static ZonedDateTime parse(CharSequence text) {
    return parse(text, DateTimeFormatter.ISO_ZONED_DATE_TIME);
}

public static ZonedDateTime parse(CharSequence text, DateTimeFormatter formatter) {
    Objects.requireNonNull(formatter, "formatter");
    return formatter.parse(text, ZonedDateTime::from);
}