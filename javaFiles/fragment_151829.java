BigDecimal step = new BigDecimal("0.1");
for (BigDecimal value = BigDecimal.ZERO;
     value.compareTo(BigDecimal.ONE) < 0;
     value = value.add(step)) {
    System.out.println(value);
}