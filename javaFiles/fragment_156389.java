public static long maxC(long map[], long coins[], int n) // n is the total number of monsters
{
    if(n == 0) // If there are no monsters in the path
        return 0;
    if(n == 1) // Just in case there is only one monster in the way
        return coins[0];
    map[0] = coins[0];
    map[1] = Math.max(map[0], coins[1]);
    for(int i = 2; i < n; i++) {
        map[i] = Math.max(map[i-2] + coins[i], map[i-1]);
    }
    return map[n - 1];
}