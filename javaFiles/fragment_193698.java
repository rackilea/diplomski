BigDecimal test = new BigDecimal(35116031);
BigInteger theInt = test.unscaledValue();
byte[] arr = theInt.toByteArray();
System.out.println(Arrays.toString(arr));

BigInteger bi2 = new BigInteger(arr);
BigDecimal bd2 = new BigDecimal(bi2, 0);
System.out.println(bd2);