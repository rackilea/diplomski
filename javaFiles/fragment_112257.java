long reproduceMinMaxFromLongToInt(long n){
    // reduce range
    n = Long.remainderUnsigned(n, 1L << 32);
    // sign-extend
    if (n < (1L << 31))
        return n;
    else
        return n - (1L << 32);
}