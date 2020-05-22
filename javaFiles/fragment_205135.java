BigDecimal _0_1 = new BigDecimal(0.1);
BigDecimal x = _0_1;
for(int i = 1; i <= 10; i ++) {
    System.out.println(i+" x 0.1 is "+x+", as double "+x.doubleValue());
    x = x.add(_0_1);
}