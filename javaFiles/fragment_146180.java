public static escapeJavaScript(String source)
{
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < source.length(); i++)
    {
        char ch = source.charAt(i);

        if (ch > 0x7F)
        {
            String hexDigits = Integer.toHexString(ch).toUpperCase();
            String escapedCh = "\\u" + "0000".substring(hexDigits.length) + hexDigits;
            result.append(escapedCh);
        }
        else
        {
            result.append(ch);
        }
    }

    return result.toString();
}