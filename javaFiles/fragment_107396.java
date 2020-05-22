private static final BigInteger MASK = BigInteger.valueOf(0xffffffff)
                                                 .shiftLeft(32);

...

public static boolean top32BitsSet(BigInteger value) {
    return value.and(MASK).equals(MASK);
}