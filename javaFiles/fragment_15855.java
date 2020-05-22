LongBuffer buffer = ByteBuffer.wrap(myBigInteger.toByteArray()).asLongBuffer();
long xor = 0;
while (buffer.hasRemaining()) {
  xor ^= buffer.get();
}
return BigInteger.valueOf(xor);