private static int fork(int current, int required, int level, int taps, int[] values, int[] costs, int maxLevel, int[][] cache) {

    if (current >= required)
        return taps;

    // check cache, calculate value only if cache is empty
    if (cache[level][current] == 0) {

        // calculate first value
        int first = Integer.MAX_VALUE;
        for (int i = level + 1; i <= maxLevel; i++) {
            if (current >= costs[i]) {
                first = fork(current - costs[i], required, i, taps, values, costs, maxLevel, cache);
            }
        }

        // calculate second value
        int second = fork(current + values[level], required, level, taps + 1, values, costs, maxLevel, cache);

        // store result in cache
        cache[level][current] = first < second ? first : second;
    }

    // return cached value
    return cache[level][current];
}