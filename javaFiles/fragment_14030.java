BigInteger randomOdd(BigInteger min, BigInteger max) {
    BigInteger range = max.subtract(min);

    // expected iterations: 2 - max iterations: infinite
    BigInteger tmp;
    do {
        tmp = new BigInteger(n.bitLength(), rng); // rng is your Random Number Generator
    } while (tmp.compareTo(range) >= 0);

    BigInteger result = min.add(tmp);

    // force the result to be odd
    // TODO: will this push it over max?
    result = result.or(BigInteger.ONE); 

    return result;
}