public static long sequentialSum(long n) {
    return LongStream.iterate(1L, i -> i+1).limit(n)
                     .reduce(0L, (i,j) -> i+j);
}

@Benchmark
public long ss() {
    return sequentialSum(n);
}