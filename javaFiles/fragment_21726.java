private static int nextPrime(int n) {
    if (n % 2 == 0)
        n++;

    while (!isPrime(n)) {
        n += 2;
    }

    return n;
}