private static final Pattern PATTERN = Pattern.compile("\\s*");

private static boolean emptyOrSpacesOnly(final String... strings)
{
    for (final String s: strings)
        if (PATTERN.matcher(s).matches())
            return true;
    return false;
}