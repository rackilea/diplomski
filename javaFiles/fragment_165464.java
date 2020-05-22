// After removing the special cases for 2 and 3 before this loop... but setting
// isPrime[2] and isPrime[3] to true
for (int p = 2; p <= limit; p++) {
    if (isPrime[p]) {
        primes[found++] = p;
    }
}