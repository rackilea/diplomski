public Element mul(PublicKey PK, Element C, Element D) {
    BigInteger t = BigIntegerUtils.getRandom(PK.getN());

    Element T = PK.doPairing(C, D);

    Element K = PK.doPairing(PK.getQ(), PK.getQ());
    K = K.pow(t);
    return T.mul(K);
}

public String decryptMul(PublicKey PK, BigInteger sk, Element C) {
    Element PSK = PK.doPairing(PK.getP(), PK.getP());
    PSK.pow(sk);

    Element CSK = C.duplicate();
    CSK.pow(sk);

    Element aux = PSK.duplicate();
    BigInteger m = new BigInteger("1");
    while (!aux.isEqual(CSK)) {
        aux = aux.mul(PSK);
        m = m.add(BigInteger.valueOf(1));
    }
    return m.toString();
}