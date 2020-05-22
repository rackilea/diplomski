public static void main(String... args) {
    int n = 9000;
    System.out.println((double) f(n * 10) / f(n));
}

private static long f(long n) {
    long sum = 0;
    for (long i = 1; i <= n; i++)   //#1
        for (long j = 1; j <= i; j++) //#2
            sum += i * j; // # 4
    return sum;
}