private static final Pattern WHITESPACE_PATTERN = Pattern.compile("(?: \\s|[\\s&&[^ ]])\\s*");

public static String normalizeSpace(final String str) {
    if (str == null) {
        return null;
    }
    return WHITESPACE_PATTERN.matcher(trim(str)).replaceAll(SPACE);
}