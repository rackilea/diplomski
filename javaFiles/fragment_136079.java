static string[] generateString(string[] letters, int len)
{
    if (len < 0) throw new ArgumentOutOfRangeException("length can't be less than zero.");
    switch (len)
    {
        case 0: return new string[0];
        case 1: return letters;
        default:
            // all possible combinations which are shorter than required 
            // recursion is used here
            var shorter_x = generateString(letters, len - 1).ToArray();

            // all combinations which have length = len - 1
            var shorter_1 = shorter_x.Where(line => line.Length == len - 1).ToArray();

            // resulting array
            return shorter_x.Union(letters.SelectMany(letter => shorter_1.Select(shorter => letter + shorter))).ToArray();
    }
}