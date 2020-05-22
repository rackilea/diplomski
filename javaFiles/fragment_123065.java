long num=5;
BigInteger numm = BigInteger.valueOf(num + 1);
BigInteger fact= BigInteger.valueOf(1);
for (; numm.compareTo(BigInteger.ONE)==1 ; fact = fact.multiply(numm)) {
    numm = numm.subtract(BigInteger.ONE);
}
System.out.println(fact.longValue());