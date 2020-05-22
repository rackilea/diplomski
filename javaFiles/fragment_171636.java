// 1.
new BigDecimal("35.3456").round(new MathContext(4, RoundingMode.HALF_UP));
//result = 35.35
// 2.
new BigDecimal("35.3456").setScale(4, RoundingMode.HALF_UP);
// result = 35.3456