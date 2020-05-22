public CipherParameters getParameters() {
    if (!isInitialized()) {
        CryptoException.throwIt(CryptoException.UNINITIALIZED_KEY);
    }
    // modulus = p * q;
    return new RSAPrivateCrtKeyParameters(p.getBigInteger().multiply(q.getBigInteger()), null,
            null, p.getBigInteger(), q.getBigInteger(),
            dp1.getBigInteger(), dq1.getBigInteger(), pq.getBigInteger());
}