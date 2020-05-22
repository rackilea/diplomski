public static int myIndexOf (String mainStr, String otherStr)
{
    // either is null
    if (mainStr == null || otherStr == null)
    {
        return -1;
    }

    int len = mainStr.length();
    int lenOfOther = otherStr.length();

    // special case: both strings are empty
    if (len == 0 && lenOfOther == 0)
    {
        return 0;
    }

    // for each char in the main string
    for (int i = 0; i < len && len - i >= lenOfOther; i++)
    {
        // see if we can match char for char in the otherStr
        int k = 0;
        while (k < lenOfOther && mainStr.charAt(k + i) == otherStr.charAt(k))
        {
            k++;
        }
        if (k == lenOfOther)
        {
            return i;
        }
    }

    // nothing found
    return -1;
}