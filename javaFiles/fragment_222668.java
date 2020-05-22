private static final Pattern HEADING_SLASHES = Pattern.compile("^/+");

// ...

public static String removeHeadingSlashes(final String input)
{
    // .replaceFirst() or .replaceAll() will have the same effect, so...
    return HEADING_SLASHES.matcher(input).replaceFirst("");
}