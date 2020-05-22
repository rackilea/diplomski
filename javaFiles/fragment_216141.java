public class RSA {
    private final BigInteger n;
    private final BigInteger e;
    private final BigInteger d;

    public RSA(final BigInteger p, final BigInteger q) {
        this.n = p.multiply(q);

        // Calculate phi
        final BigInteger pMinusOne = p.subtract(BigInteger.ONE);
        final BigInteger qMinusOne = q.subtract(BigInteger.ONE);
        final BigInteger phi = pMinusOne.multiply(qMinusOne);

        // Calculate e
        BigInteger e = BigInteger.valueOf(3L);
        while (! phi.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }
        this.e = e;

        // Calculate d
        this.d = e.modInverse(phi);
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }
}