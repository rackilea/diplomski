static byte[] dropParity(byte[] desKey) {
    if(desKey.length!=8) throw new IllegalArgumentException();
    BitSet in=BitSet.valueOf(desKey);
    BitSet out=new BitSet(56);
    for(int byteIndex=0, inIndex=0, outIndex=0; byteIndex<8; byteIndex++, inIndex++)
      for(int bitIndex=0; bitIndex<7; bitIndex++) out.set(outIndex++, in.get(inIndex++));
    byte[] byteArray = out.toByteArray();
    if(byteArray.length<7) // last byte(s) are zero
      byteArray=Arrays.copyOf(byteArray, 7);
    return byteArray;
}
static byte[] regenerateParity(byte[] desKey) {
    if(desKey.length!=7) throw new IllegalArgumentException();
    BitSet in=BitSet.valueOf(desKey);
    BitSet out=new BitSet(64);
    for(int byteIndex=0, inIndex=0, outIndex=0; byteIndex<8; byteIndex++)
    {
      boolean even=true;
      for(int bitIndex=0; bitIndex<7; bitIndex++) {
        final boolean bit = in.get(inIndex++);
        out.set(outIndex++, bit);
        even ^= bit;
      }
      out.set(outIndex++, even);
    }
    return out.toByteArray();
}