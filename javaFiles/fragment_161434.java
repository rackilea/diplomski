// Two example numbers:
BigDecimal val0 = new BigDecimal("1.4350");
BigDecimal val1 = new BigDecimal("1.4300");


// This might be a method:

if (val0.scale() != val1.scale())
    throws new IllegalArgumentException("Scales are not the same!");

BigDecimal subtr = val0.subtract(val1);
System.out.println(subtr); // Prints 0.0050

BigInteger unscaled = subtr.unscaledValue();
System.out.println(unscaled); // Prints 50