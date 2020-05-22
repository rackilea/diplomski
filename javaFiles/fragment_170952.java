static Pattern regex = Pattern.compile("\\^");

private static String getEntry(String input, int which)
{
    return regex.split(input)[which];
}