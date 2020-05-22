ByteBuffer intConv = ByteBuffer.allocate(16);
intConv.putInt(0, len);
out.write(intConv.array(),0,4);
for (int i=0; i < len; i+=4) {
    for(int j=0; j<4; j++)
        intConv.putInt(4*j, i);
    out.write(intConv.array());
}