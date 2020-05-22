private static long sumPrimes(boolean[] seedPrime, boolean[] rangePrime, int min, int max/*inclusive*/) {
    // Initialize range
    for (int i = Math.max(min, 2); i <= max; i++) {
        rangePrime[i - min] = true;
    }

    // Mark non-primes in range
    int maxPrime = (int) Math.sqrt(max + 1); // extra to be sure no "float errors" occur
    for (int prime = 2; prime <= maxPrime; prime++) {
        if (seedPrime[prime]) {
            int minMultiple = (min + prime - 1) / prime * prime;
            if (minMultiple <= prime)
                minMultiple = prime * 2;
            for (int multiple = minMultiple; multiple <= max ; multiple += prime) {
                rangePrime[multiple - min] = false;
            }
        }
    }

    // Sum the primes
    long sum = 0;
    for (int prime = min; prime <= max; prime++) {
        if (rangePrime[prime - min]) {
            sum += prime;
        }
    }
    return sum;
}