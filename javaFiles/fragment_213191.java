BigDecimal bg1 = new BigDecimal(16.543242123);
  bg1 = bg1.setScale(1, BigDecimal.ROUND_HALF_EVEN);
  System.out.println(bg1.toString());  //16.5

  BigDecimal bg2 = new BigDecimal(3.35);
  bg2 = bg2.setScale(1, BigDecimal.ROUND_HALF_EVEN);
  System.out.println(bg2.toString()); //3.4

  BigDecimal bg3 = new BigDecimal(6.3456);
  bg3 = bg3.setScale(1, BigDecimal.ROUND_HALF_EVEN);
  System.out.println(bg3.toString());  //6.3