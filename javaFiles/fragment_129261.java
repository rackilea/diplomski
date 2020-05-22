public static final long primeSum(final long maximum) {
    if (maximum < 2L) return 0L;
    long sum = 2L;

    // Put a label here so that we can skip to the next outer loop iteration.
    outerloop:
    for (long possPrime = 3L; possPrime <= maximum; possPrime += 2L) {
        for (long possDivisor = 3L; possDivisor*possDivisor <= possPrime; possDivisor += 2L) {
            // If we find a divisor, continue with the next outer loop iteration.
            if (possPrime % possDivisor == 0L) continue outerloop;
        }
        // This possible prime passed all tests, so it's an actual prime.
        sum += possPrime;
    }

    return sum;
}