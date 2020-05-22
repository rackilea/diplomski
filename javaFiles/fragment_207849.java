public static String zipZap(String str)
{
    if (str.length() < 2)
        return str;

    String result = str.substring(0, 1);

    for (int i = 1; i < (str.length() - 1); i++)
    {
        if ((str.charAt(i - 1) != 'z') || (str.charAt(i + 1) != 'p'))
            result += str.charAt(i);
    }

    result += str.substring(str.length() - 1);

    return result;
}

Input: azbcpzpp
Output: azbcpzp