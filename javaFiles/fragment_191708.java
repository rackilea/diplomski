private static int printSyra(BigInteger num, int count) {
    if (num.equals(BigInteger.ONE)) {
        return count;
    }
    if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
        return printSyra(num.divide(BigInteger.valueOf(2)), count + 1);
    } else {
        return printSyra(num.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE), count + 1);
    }
}