BigDecimal one = new BigDecimal(1);

BigDecimal thirtyThree = new BigDecimal(33);

//Fix the decimals you want, i.e. 21
MathContext context = new MathContext(21, RoundingMode.DOWN);

BigDecimal result = one.divide(thirtyThree, context);       

System.out.println(result);