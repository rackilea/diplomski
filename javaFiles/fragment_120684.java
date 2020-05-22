ByteBuffer intConv = ByteBuffer.allocate(16);
in.read(intConv.array(),0,4);
int len = intConv.getInt(0);
for (int i=0; i < len; i+=4) {
    in.read(intConv.array());
    for(int j=0; j<4; j++)
    {
      int val=intConv.getInt(j*4);
    }
}