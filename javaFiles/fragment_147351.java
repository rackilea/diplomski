for(final byte b : md.digest()) {
  // get high 4 bytes of current byte
  final int h = b >> 4 & 0x0F;
  // convert into hex digit (0x30 is '0' while 0x57+10 is 'a')
  tb.add((byte) (h + (h > 9 ? 0x57 : 0x30))); 
  // the same for the bottom 4 bits
  final int l = b & 0x0F;
  tb.add((byte) (l + (l > 9 ? 0x57 : 0x30)));
}