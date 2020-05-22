Random rnd = new Random(123);
BigInteger tenPow30 = new BigInteger("10").pow(30);
BigInteger min = new BigInteger("10").pow(29);
BigInteger r;
do {
        r = new BigInteger(100, rnd).remainder(tenPow30);
} while (r.compareTo(min) < 0);
System.out.println(r);