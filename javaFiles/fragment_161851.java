public static int sum(int z, int x, int y)
{
    // Compute number of calls
    int[][] calls = new int[x+1][x*y+1];
    calls[0][0] = 1;
    for (int i = 0; i < x; i++) {
        for (int j = 0; j <= x*y; j++) {
            for (int target = j+1; target <= j+y && target <= x*y; target++) {
                calls[i+1][target] += calls[i][j];
            }
        }
    }

    // Return count of last column where z <= 0
    int result = 0;
    for (int j = x*y; z-j <= 0; j--) {
        result += calls[x][j];
    }
    return result;
}