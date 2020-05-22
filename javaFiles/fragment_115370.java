int prime = 2106945901;
for (int i = 0; i < 10; i++) {
    long start = System.nanoTime();
    long answer1 = BigInteger.valueOf(prime)
                             .modPow(
                                 BigInteger.valueOf(prime), 
                                 BigInteger.valueOf(2).pow(32)).longValue();

    long mid = System.nanoTime();
    int answer2 = 1;
    int p = prime;
    for (int n = prime; n > 0; n >>>= 1) {
        if ((n & 1) != 0)
            answer2 *= p;
        p *= p;
    }
    long end = System.nanoTime();
    System.out.printf("True answer %,d took %.3f ms, quick answer %,d took %.3f ms%n",
            answer1, (mid - start) / 1e6, answer2 & 0xFFFFFFFFL, (end - mid) / 1e6);
}