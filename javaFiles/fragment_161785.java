public static boolean test(int[][] large, int[][] small)
{
    for (int x = 0; x < large.length - 1; x++)
        for (int y = 0; y < large[0].length - 1; y++)
        {
            int[][] part = cut(large, x, y);
            if (Arrays.deepEquals(part, small))
                return true;
        }
}