private static BufferedImage edgeDetection(BufferedImage img, int[] kernel){
       int height = img.getHeight();
       int width = img.getWidth();

       BufferedImage result = new BufferedImage(width -1, height -1, BufferedImage.TYPE_INT_RGB);
       for(int x = 1; x < width -1 ; x++){
           for(int y = 1; y < height - 1; y++){
               int [] tmp = {img.getRGB(x-1, y-1)&0xff,img.getRGB(x, y-1)&0xff,img.getRGB(x+1, y-1)&0xff,
               img.getRGB(x-1, y)&0xff,img.getRGB(x, y)&0xff,img.getRGB(x+1, y)&0xff,img.getRGB(x-1, y+1)&0xff,
               img.getRGB(x, y+1)&0xff,img.getRGB(x+1, y+1)&0xff};
               int value = convolution (kernel, tmp);
               result.setRGB(x,y, 0xff000000|(value<<16)|(value<<8)|value);
           }
       }
       return result;
   }