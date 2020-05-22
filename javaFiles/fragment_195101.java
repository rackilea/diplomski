private void embedMessage(BufferedImage img, String mess) {
   int messageLength = mess.length();

   int imageWidth = img.getWidth(), imageHeight = img.getHeight(),
      imageSize = imageWidth * imageHeight;
   if((messageLength * 8 + 32)/3 > imageSize) {
      JOptionPane.showMessageDialog(this, "Message is too long for the chosen image",
         "Message too long!", JOptionPane.ERROR_MESSAGE);
      return;
      }
   embedInteger(img, messageLength, 0);

   byte b[] = mess.getBytes();
   for(int i=0; i<b.length; i++)
      embedByte(img, b[i], i*8+32);
   }

private void embedInteger(BufferedImage img, int n, int start) {
   int mod = start%3;
   start = start/3;
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   for(int i=startX; i<maxX && count<32; i++) {
      for(int j=startY; j<maxY && count<32; j++) {
         int rgb = img.getRGB(i, j), bit = 0, pp = 0;
         if(count <= 29) {
            for(pp=mod; pp<3; pp++) {
               bit = getBitValue(n, count); rgb = setBitValue(rgb, 8*pp, bit);
               count += 1;
               }
            mod = 0;
            }
         else {
            for(pp=0; pp<(33-count); pp++) {
               bit = getBitValue(n, count); rgb = setBitValue(rgb, 8*pp, bit);
               count += 1;
               }
            }
         img.setRGB(i, j, rgb);
         }
      }
   }

private void embedByte(BufferedImage img, byte b, int start) {
   int mod = start%3;
   start = start/3;
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   for(int i=startX; i<maxX && count<8; i++) {
      for(int j=startY; j<maxY && count<8; j++) {
         if(j==maxY-1){
            startY = 0;
            }
         int rgb = img.getRGB(i, j), bit = 0, pp = 0;
         if(count <= 5) {
            for(pp=mod; pp<3; pp++) {
               bit = getBitValue(b, count); rgb = setBitValue(rgb, 8*pp, bit);
               count += 1;
                  }
            mod = 0;
            }
         else {
            for(pp=0; pp<(9-count); pp++) {
               bit = getBitValue(b, count); rgb = setBitValue(rgb, 8*pp, bit);
               count += 1;
               }
            }        
         img.setRGB(i, j, rgb);
         }
      }
   }