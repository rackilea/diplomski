String searchLongestPattern (String base, String pattern)
{
    for (int endOffset = pattern.length() ; endOffset >= 1 ; endOffset--)
    {
        String match = null;
        if (base.indexOf(match = pattern.substring(0, endOffset)) != -1 || base.indexOf(match = pattern.substring(pattern.length() - endOffset + 1)) != -1)
        {
            return match;
        }
    }
    return null;
}