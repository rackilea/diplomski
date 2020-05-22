public static byte[] enc(byte[] piecedata,byte[] k1,byte[] k2){
byte[] result=new byte[16];
byte[] pt1,pt2;
pt1=Arrays.copyOfRange(piecedata, 0, 8);
pt2=Arrays.copyOfRange(piecedata, 8, 16);
for(int si = 0; si < 32; si++) {
     k1=generateKey(k1,k2,si);
     k2=generatekey2(k1,k2);
    pt1=circularBitShiftingRight(pt1,8);
    pt1=plus(pt1,pt2);
    for(int i=0;i<8;i++)
        pt1[i]=(byte) (pt1[i]^k2[i]);
    pt2=circularBitShiftingLeft(pt2,3);
    for(int i=0;i<8;i++)
        pt2[i]=(byte) (pt1[i]^pt2[i]);
   }    
System.arraycopy(pt1,0,result,0,8);
System.arraycopy(pt2,0,result,8,8);
return result;
}