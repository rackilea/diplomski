//Square root of 5 will give you a lot of decimals    
BigDecimal d1 = new BigDecimal(sqrt(5));
//5 will give you none
BigDecimal d2 = new BigDecimal(5);
//Print and enjoy
System.out.println(d1.stripTrailingZeros());
System.out.println(d2.stripTrailingZeros());