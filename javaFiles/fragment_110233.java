for (int divider = 2; divider <= number; divider++) {
    boolean isPrime = true;
    for (int i = 0; i < primeCount && isPrime; i++) {
        isPrime = number % arrayPrime[i] > 0;
    }
    if (isPrime)
        arrayPrime[primeCount++] = divider;
}