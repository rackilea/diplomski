/**
 * Return 10 to the power n, as a {@code BigInteger}.
 *
 * @param  n the power of ten to be returned (>=0)
 * @return a {@code BigInteger} with the value (10<sup>n</sup>)
 */
private static BigInteger bigTenToThe(int n) {
    if (n < 0)
        return BigInteger.ZERO;

    if (n < BIG_TEN_POWERS_TABLE_MAX) {
        BigInteger[] pows = BIG_TEN_POWERS_TABLE;
        if (n < pows.length)
            return pows[n];
        else
            return expandBigIntegerTenPowers(n);
    }
    // BigInteger.pow is slow, so make 10**n by constructing a
    // BigInteger from a character string (still not very fast)
    char tenpow[] = new char[n + 1];
    tenpow[0] = '1';
    for (int i = 1; i <= n; i++)
        tenpow[i] = '0';                
    return new BigInteger(tenpow);
}