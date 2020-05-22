// Take care of negative values
long l = (bigInt.compareTo(BigInteger.ZERO) < 0) ? -1 : 0;
byte[] array = bigInt.toByteArray();
for(int i=0; i<array.length-1; i++) {
    l |= array[i] & 0xFF;
    l <<= 8;
}
l |= array[array.length-1] & 0xFF;