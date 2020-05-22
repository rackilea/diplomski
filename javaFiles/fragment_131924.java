public static BigInteger multiplyAll(long from, long to, int split) {
    if(split < 1 || to - from < 2) return serial(from, to);
    split--;
    long middle = (from + to) >>> 1;
    return multiplyAll(from, middle, split).multiply(multiplyAll(middle, to, split));
}

private static BigInteger serial(long l1, long l2) {
    BigInteger bi = BigInteger.valueOf(l1++);
    for(; l1 < l2; l1++) {
        bi = bi.multiply(BigInteger.valueOf(l1));
    }
    return bi;
}