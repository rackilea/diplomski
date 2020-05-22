public static int count_number_of_ways(int amount, int index, Integer[][] cache, int[] denominations) {
    if (cache == null)
        cache = new Integer[denominations.length][amount + 1];
    if (amount == 0) {
        int ret = 1;
        cache[index][amount] = ret;
        return ret;
    }
    if (cache[index][amount] != null) {
        return cache[index][amount];
    }
    int ret = 0;
    if (index + 1 < denominations.length)
        ret += count_number_of_ways(amount, index + 1, cache, denominations);
    if (amount >= denominations[index])
        ret += count_number_of_ways(amount - denominations[index], index, cache, denominations);
    cache[index][amount] = ret;
    return ret;
}