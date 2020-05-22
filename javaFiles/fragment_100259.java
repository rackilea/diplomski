long divTime = 0;
    long substrTime = 0;
    final int bitsCount = 1000;

    for (int i = 0; i < 1000; ++i) {
        long t1, t2;
        BigInteger random = new BigInteger(bitsCount, new Random());

        t1 = System.currentTimeMillis();
        random.divide(BigInteger.TEN);
        t2 = System.currentTimeMillis();
        divTime += (t2 - t1);

        t1 = System.currentTimeMillis();
        String str = random.toString();
        new BigInteger(str.substring(0, str.length() - 1));
        t2 = System.currentTimeMillis();
        substrTime += (t2 - t1);
    }

    System.out.println("Divide: " + divTime);
    System.out.println("Substr: " + substrTime);
    System.out.println("Ratio:  " + (substrTime / divTime));