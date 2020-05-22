BigDecimal oneNinth25 = BigDecimal.ONE.divide(BigDecimal.valueOf(9), 25, BigDecimal.ROUND_HALF_UP);
BigDecimal oneNinth26 = BigDecimal.ONE.divide(BigDecimal.valueOf(9), 26, BigDecimal.ROUND_HALF_UP);
MathContext mathContext = new MathContext(25, RoundingMode.HALF_UP);

System.out.println("1/9 to 25 digits / 3 = " + 
                   oneNinth25.divide(BigDecimal.valueOf(3), mathContext));
System.out.println("1/9 to 26 digits / 3 = " + 
                   oneNinth26.divide(BigDecimal.valueOf(3), mathContext));