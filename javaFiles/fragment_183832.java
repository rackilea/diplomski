maxPrime = (int) Math.sqrt(max);
for (int prime = 2; prime <= maxPrime; prime++) {
    if (array[prime]) {
        int lower = (min + prime - 1) / prime * prime;
        for (int i = lower; i < max; i += prime)
            array[i] = false