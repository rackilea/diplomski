int[] primes(int num) {
    if (num < 1) {
        return new int[0];
    }
    int[] primes = new int[num];
    int curTest = 2;
    int count = 0;
    while (count < num) {
        if (isPrime(curTest)) {
            primes[count] = curTest;
            count++;
        }
        curTest++;
    }
    return primes;
}

boolean isPrime(int test) {
    for (int i = 2; i <= Math.sqrt(test); i++) {
        if (test % i == 0) {
            return false;
        }
    }
    return true;
}