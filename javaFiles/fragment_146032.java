addBlacks(int blackThreshold) {
  for (x = 0; x < image.getWidth(); x++) {
    for (y = 0; y < image.getHeight(); y++) {
      int rgb = bim.getRGB(x, y)&0x00ffffff;
      int rr=(rgb&0x00ff0000)>>16, rg=(rgb&0x0000ff00)>>8, rb=rgb&0x000000ff;
    if(rr<blackThreshold && rg<blackThreshold && rb<blackThreshold)
      rr=rg=rb=0;
    b2.setRGB(x, y, 0xff000000|(rr<<16)|(rg<<8)|rb);
  }
}