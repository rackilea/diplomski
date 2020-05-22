static string[] generateString(char[] letters, int len)
{
    if (len < 0) throw new ArgumentOutOfRangeException("length can't be less than zero.");
    switch (len)
    {
        case 0: return new string[0];
        case 1: return letters.Select(char.ToString).ToArray();
        default:
            ......