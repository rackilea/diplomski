private static final BigInteger TWO_COMPL_REF = BigInteger.ONE.shiftLeft(64);

    public static byte[] parseBigIntegerPositive(BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) < 0)
            b = b.add(TWO_COMPL_REF);

       byte[] unsignedbyteArray= b.toByteArray();
        return unsignedbyteArray;
    }