public static String LetterChanges(String str)
{
    str = str.toLowerCase();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++)
    {
        char c = str.charAt(i);

        if ('a' <= c && c <= 'z')
        {
            c = (c == 'z') ? 'a' : (char) (c + 1);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                c = Character.toUpperCase(c);
            }
        }
        sb.append(c);
    }
    return sb.toString();
}