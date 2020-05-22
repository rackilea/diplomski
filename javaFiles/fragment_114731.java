public static String replace(String needle, String hayStack, String replacement)
{
    String origNeedle = needle;
    String origHayStack = hayStack;

    needle = origNeedle.toLowerCase();
    hayStack = origHayStack.toLowerCase();

    int hayStackLen = hayStack.length();
    int needleLen = needle.length();
    int from = 0;
    int to;

    String stuffBeforeNeedle;
    StringBuilder output = new StringBuilder();

    do
    {
        to = hayStack.indexOf(needle, from);
        if (to == -1)
            to = hayStackLen;

        stuffBeforeNeedle = hayStack.substring(from, to);
        output.append(stuffBeforeNeedle);

        if (to < hayStackLen)
            output.append( replacement );

        from = hayStack.indexOf(needle, to) + needleLen;
    }
    while (to < hayStackLen);

    return output.toString();
}