private void decodeMessage() {
   int len = extractInteger(image, 0);
   byte b[] = new byte[len];
   for(int i=0; i<len; i++)
      b[i] = extractByte(image, i*8+32);
   message.setText(new String(b));
   }

private int extractInteger(BufferedImage img, int start) {
   int mod = start%3;
   start = start/3;
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   int length = 0;
   for(int i=startX; i<maxX && count<32; i++) {
      for(int j=startY; j<maxY && count<32; j++) {
         int rgb = img.getRGB(i, j), bit = 0, pp = 0;
         if(count <= 29) {
            for(pp=mod; pp<3; pp++) {
               bit = getBitValue(rgb, 8*pp); length = setBitValue(length, count, bit);
               count += 1;
               }
            mod = 0;
            }
         else {
            for(pp=0; pp<(33-count); pp++) {
               bit = getBitValue(rgb, 8*pp); length = setBitValue(length, count, bit);
               count += 1;
               }
            }
         }
      }
   return length;
   }

private byte extractByte(BufferedImage img, int start) {
   int mod = start%3;
   start = start/3;
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   byte b = 0;
   for(int i=startX; i<maxX && count<8; i++) {
      for(int j=startY; j<maxY && count<8; j++) {
         if(j==maxY-1){
            startY = 0;
            }
         int rgb = img.getRGB(i, j), bit = 0, pp = 0;
         if(count <= 5) {
            for(pp=mod; pp<3; pp++) {
               bit = getBitValue(rgb, 8*pp); b = (byte)setBitValue(b, count, bit);
               count += 1;
               }
            mod = 0;
            }
         else {
            for(pp=0; pp<(9-count); pp++) {
               bit = getBitValue(rgb, 8*pp); b = (byte)setBitValue(b, count, bit);
               count += 1;
               }
            }
         }
      }
   return b;
   }