static <T> Collector<T,?,Integer> hashing() {
    return Collector.of(() -> new int[2],
        (a,o)    -> { a[0]=a[0]*31+Objects.hashCode(o); a[1]++; },
        (a1, a2) -> { a1[0]=a1[0]*iPow(31,a2[1])+a2[0]; a1[1]+=a2[1]; return a1; },
        a -> iPow(31,a[1])+a[0]);
}
// derived from http://stackoverflow.com/questions/101439
private static int iPow(int base, int exp) {
    int result = 1;
    for(; exp>0; exp >>= 1, base *= base)
        if((exp & 1)!=0) result *= base;
    return result;
}