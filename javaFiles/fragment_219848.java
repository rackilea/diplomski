public static long sumOfPrimes(int n) {

    long sum = 0;

    boolean[] sieve = new boolean[n];
    for(int i = 2; i < Math.sqrt(n); i++) {
        if(!sieve[i]) {
            for(int j = i * i; j < n; j += i) {
                sieve[j] = true;
            }
        }
    }

    for(int i = 2; i < n; i++) {
        if(!sieve[i]) {             
            sum += i;
        }
    }

    return sum;
}