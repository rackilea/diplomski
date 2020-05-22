private boolean isPrime(int number) {
    for (int i = 0; i < primeCount; i++) {
        int prime = arrayPrime[i];
        if (prime * prime > number)
            break;
        else if (number % prime == 0)
            return false;
    }
    return true;
}