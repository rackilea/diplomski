public static int calculateMainDiagonal(int[][] m) // <-- no semicolon.
{
    int total = 0;
    for (int r = 0; r < m.length; r++) // <-- not r < total.
    {
        if (r < m[r].length) {
            total += m[r][r];
        }
    }
    return total;
}