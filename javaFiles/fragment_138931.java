// 2⁶⁴
private static BigInteger twoP64=BigInteger.ZERO.flipBit(64);

public static BigInteger getNumBytes()
{
  long longValue=getNumByteNative();
  BigInteger i=BigInteger.valueOf(longValue);
  if(longValue<0) i=i.add(twoP64);
  return i;
}

private native long getNumByteNative();