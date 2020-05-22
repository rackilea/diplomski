BigDecimal b1 = new BigDecimal("0.90");
BigDecimal b2 = new BigDecimal("0.20");
if(b1.add(b2).intValue() > Math.max(b1.intValue(), b2.intValue())){
    System.out.println("The integral has changed");
}else {
    System.out.println("The integral is the same");
}