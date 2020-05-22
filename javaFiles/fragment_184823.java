int size = bmpData.getRowBytes()*bmpData.getHeight()*4;
ByteBuffer buf = ByteBuffer.allocate(size);
bmpData.copyPixelsToBuffer(buf);
byte[] byt = buf.array();
  for(int ctr=0;ctr<size;ctr+=4)
    {
      //access array in form of argb. for ex. byt[0] is 'r', byt[1] is 'g' and so on..
    }
ByteBuffer retBuf = ByteBuffer.wrap(byt);
bmpData.copyPixelsFromBuffer(retBuf);