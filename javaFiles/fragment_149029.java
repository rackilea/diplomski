for (int y = 0; y < image.getHeight(); y++) {
    for (int x = 0; x < image.getWidth(); x++) {
          int  clr   = image.getRGB(x, y); 
          int  red   = (clr & 0x00ff0000) >> 16;
          int  green = (clr & 0x0000ff00) >> 8;
          int  blue  =  clr & 0x000000ff;
          image.setRGB(x, y, clr);
    }
}