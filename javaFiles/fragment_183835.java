public static void main(String[] args) {
    test(1000, 3);
    test(100000000, 4);
}
public static void test(int n, int threadCount) {
    long start = System.nanoTime();
    long sum = sumPrimes(n, threadCount);
    long end = System.nanoTime();
    System.out.printf("sumPrimes(%,d, %d) = %,d (%.9f seconds)%n",
                      n, threadCount, sum, (end - start) / 1e9);
}