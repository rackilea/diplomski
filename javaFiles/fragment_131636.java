for (int i = 0; i < text.length(); i++)
{
    int codePoint = text.codePointAt(i);
    // Skip over the second char in a surrogate pair
    if (codePoint > 0xffff)
    {
        i++;
    }
    System.out.println(codePoint);
}