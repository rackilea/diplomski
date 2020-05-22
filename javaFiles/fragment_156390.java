public static long maxC(long map[], long coins[], int n)
{
    if(n-1 < 0)
        return 0;
    if(map[n - 1] != 0) {
        return map[n - 1];
    }
    map[n - 1] = Math.max(maxC(map, coins, n-2) + coins[n - 1], maxC(map, coins, n-1));
    return map[n - 1];
}