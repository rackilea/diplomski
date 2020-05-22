System.out.println(Long.MAX_VALUE);
long BLZ = 12345678l;
long KNr = 1234567890l;
String landCode = "1314";
String val = String.valueOf(BLZ) + String.valueOf(KNr) + landCode + "00";
System.out.println(val); 
System.out.println(BigInteger.valueOf(98).subtract(new BigInteger(val).mod(BigInteger.valueOf(97))));