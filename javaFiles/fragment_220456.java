private static int leftmostZeroBit(int a) {
    int b = Integer.highestOneBit(a);
    return (b == 0 ? -1 : 31 - Integer.numberOfLeadingZeros(a ^ b ^ (b - 1)));
}

private static int leftmostZeroBit(long a) {
    long b = Long.highestOneBit(a);
    return (b == 0 ? -1 : 63 - Long.numberOfLeadingZeros(a ^ b ^ (b - 1)));
}