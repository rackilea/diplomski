BigDecimal bd  = new BigDecimal(23.086); 
BigDecimal bd1 = new BigDecimal(0.000);

bd  = bd.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros(); 
bd1 = bd1.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();

System.out.println("bd value::"+ bd); System.out.println("bd1 value::"+ bd1);
System.out.println("new way:" + bd1.intValueExact());