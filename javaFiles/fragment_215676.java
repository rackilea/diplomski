void funPrimes(int start, int end) {
    for (int n = start; n < end; n++) {
        if (isPrime(n) && digitsAddToTen(n)) {
            System.out.println(n);
        }
    }
}

boolean isPrime(int num) {
    boolean p = true;
    for (int i = 2; i < num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return p;
}

boolean digitsAddToTen(int num) {
    int digitTotal = 0;
    while (num > 0) {
        digitTotal += num % 10;
        num = num / 10;
    }
    return (digitTotal % 10 == 0);
}