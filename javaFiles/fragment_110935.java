public static long sequentialSumBoxed(long n) {
    return Stream.iterate(1L, i -> i+1).limit(n)
                 .reduce(0L, (i,j) -> i+j);
}

@Benchmark
public long ssb() {
    return sequentialSumBoxed(n);
}