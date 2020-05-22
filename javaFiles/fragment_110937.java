public static long rangeSum(long n) {
    return LongStream.rangeClosed(1, n).sum();
}

@Benchmark
public long rs() {
    return rangeSum(n);
}