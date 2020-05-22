void funPrimes(int start, int end) {
    int ten = 0;
    for (int n = start; n < end; n++) {
        ten = 0;
        int current = n;
        while (current > 0) {
            ten += current % 10;
            current = current / 10;
        }
        if (isPrime(n) && ten % 10 == 0) {
            System.out.println(n);
        }
    }
}