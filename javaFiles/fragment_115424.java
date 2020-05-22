private boolean containsIllegalCharacters(String displayName)
{
    final int nameLength = displayName.length();

    for (int i = 0; i < nameLength; i++)
    {
        final char hs = displayName.charAt(i);

        if (0xd800 <= hs && hs <= 0xdbff)
        {
            final char ls = displayName.charAt(i + 1);
            final int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;

            if (0x1d000 <= uc && uc <= 0x1f77f)
            {
                return true;
            }
        }
        else if (Character.isHighSurrogate(hs))
        {
            final char ls = displayName.charAt(i + 1);

            if (ls == 0x20e3)
            {
                return true;
            }
        }
        else
        {
            // non surrogate
            if (0x2100 <= hs && hs <= 0x27ff)
            {
                return true;
            }
            else if (0x2B05 <= hs && hs <= 0x2b07)
            {
                return true;
            }
            else if (0x2934 <= hs && hs <= 0x2935)
            {
                return true;
            }
            else if (0x3297 <= hs && hs <= 0x3299)
            {
                return true;
            }
            else if (hs == 0xa9 || hs == 0xae || hs == 0x303d || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c || hs == 0x2b1b || hs == 0x2b50)
            {
                return true;
            }
        }
    }

    return false;
}