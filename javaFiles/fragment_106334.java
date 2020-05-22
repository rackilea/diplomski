// Sample variable name - you'd probably name this better.
public static DateTimeFormat LONG_FORMATTER = DateTimeFormatter.forPattern("yyyy MM dd HH:mm:ss.SSS");

// Note that this could easily take a DateTime directly if that's what you've got.
// Hint hint non-null valid date hint hint.
public static String formatAndChopEmptyMilliseconds(final Date nonNullValidDate) {
    final String formattedString = LONG_FORMATTER.print(new DateTime(nonNullValidDate));
    return formattedString.endsWith(".000") ? formattedString.substring(0, formattedString.length() - 4) : formattedString;
}