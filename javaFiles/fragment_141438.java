BigDecimal bd1 = new BigDecimal(0.13); // double value to BigDecimal
BigDecimal bd2 = new BigDecimal("0.21"); // String value to BigDecimal

MathContext mc = new MathContext(3, RoundingMode.HALF_EVEN); // first arg is the precision and the second is the RoundingMode.

BigDecimal bd3 = bd1.add(bd2, mc); // perform the addition with the context

System.out.println(bd3); // prints 0.340