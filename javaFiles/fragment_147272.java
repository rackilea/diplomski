public static int count(char[] chars, char ch)
{
    return count(chars, ch, chars.length - 1);
}

public static int count(char[] chars, char ch, int high)
{
    if (high == -1)
    {
        return 0;
    }
    if (chars[high] == ch)
    {
        return 1 + count(chars, ch, high - 1);
    }
    return count(chars, ch, high - 1);
}