BigInteger myBI = new BigInteger("1000000000000000000000000000000000000000000000000000000");
    double d = 0.1;
    BigDecimal bd = new BigDecimal(myBI);

    BigInteger doubleWithStringValue = bd.multiply(BigDecimal.valueOf(d)).toBigInteger();

    BigDecimal bdresult = bd.multiply(new BigDecimal(d));
    BigInteger unrounded = bdresult.toBigInteger();
    BigInteger correct = bdresult.add(new BigDecimal("0.5")).toBigInteger(); // this way of rounding assumes positive numbers
    BigInteger lostprecision = new BigDecimal(myBI.doubleValue() * d).toBigInteger();

    System.out.println("DoubleString:   " + doubleWithStringValue);

    System.out.println("Unrounded:      " + unrounded);
    System.out.println("Correct:        " + correct);
    System.out.println("Lost precision: " + lostprecision);