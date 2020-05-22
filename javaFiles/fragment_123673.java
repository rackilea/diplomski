static String dropParityAndConvertToASCII(byte[] desKey) {
    if(desKey.length!=8) throw new IllegalArgumentException();
    char[] ch=new char[8];
    for(int i=0; i<8; i++) ch[i]=(char)((desKey[i]>>1)&0x7F);
    return new String(ch);
}
static byte[] convertFromASCIIAndAddParityBit(String desKey) {
    if(desKey.length()!=8) throw new IllegalArgumentException();
    byte[] ba=new byte[8];
    for(int i = 0; i < 8; i++) {
        int b = desKey.charAt(i)<<1;
        ba[i] = (byte)(b | Integer.bitCount(b)&1^1);
    }
    return ba;
}