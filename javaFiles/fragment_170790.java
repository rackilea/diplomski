BigInteger i = BigInteger.valueOf(99L);
BigInteger j = BigInteger.valueOf(1000000000000L);
BigInteger ans = BigInteger.ZERO;
if (j.compareTo(i) > 0) {
    BigInteger sumTill_j = (j.multiply(j.add(BigInteger.ONE))).divide(BigInteger.valueOf(2L));
    BigInteger sumTill_i = ((i.subtract(BigInteger.ONE)).multiply(i)).divide(BigInteger.valueOf(2L));
    ans = sumTill_j.subtract(sumTill_i);
    System.out.println(ans);
}