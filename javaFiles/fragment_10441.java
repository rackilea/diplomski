BigInteger n = BigInteger.ONE;
BigInteger p = BigInteger.ZERO;
BigInteger TWO = new BigInteger("2");
for (int i = 1; i <= 64; i++) {
    StringBuilder sb = new StringBuilder();
    sb.append("For square #: " + i);
    sb.append(", Grains on square: " + n);
    p = p.add(n);
    n = n.multiply(TWO);
    sb.append(", Running Total: " + p);
    System.out.println(sb.toString());
}