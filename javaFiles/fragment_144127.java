private static final Pattern namePattern =
    Pattern.compile("^[-' \\p{L}\\p{M}]+$");

public static boolean isValidName(String text) {
    return namePattern.matcher(text).matches()
        && text.indexOf("  ") < 0
        && !text.startsWith(" ") && !text.endsWith(" ");
}