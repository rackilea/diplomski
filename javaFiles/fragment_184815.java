public static byte[] dec(byte[] pieceofdata,byte[] keys){
byte[] result=new byte[16];
byte[] key;
byte[] ct1,ct2;
int m;
ct1=Arrays.copyOfRange(pieceofdata, 0, 8);
ct2=Arrays.copyOfRange(pieceofdata, 8, 16);
for(int i=0;i<32;i++){
    m=256-((i+1)*8);
      key=Arrays.copyOfRange(keys,m,m+8);
    for(int j=0;j<8;j++)
        ct2[j]=(byte) (ct1[j]^ct2[j]);
    ct2=circularBitShiftingRight(ct2,3);
    for(int j=0;j<8;j++)
        ct1[j]=(byte) (ct1[j]^key[j]);
    for(int j=0;j<8;j++)
        ct1[j]=(byte) (ct1[j]-ct2[j]);
    ct1=circularBitShiftingLeft(ct1,8); 
}   
System.arraycopy(ct1, 0, result, 0, 8);
System.arraycopy(ct2, 0, result, 8, 8);
return result;}