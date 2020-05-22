private boolean isPrime(int number) {
    for (int i = 0; i < primeCount; i++) {
        if (number % arrayPrime[i] == 0)
            return false;
    }
    return true;
}