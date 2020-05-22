BigInteger bi = new BigInteger("99999999999999999999999999");
BigInteger mv = new BigInteger(String.valueOf(Integer.MAX_VALUE));
System.out.println(bi.compareTo(mv));

if (bi.compareTo(mv) > 0) 
    return Integer.MAX_VALUE;
else 
    return bi.intValue();