private int clickAlphaValue(BufferedImage bufImg, int posX, int posY) 
  {
    int alpha;

    alpha = (bufImg.getRGB(posX, posY) >>24) & 0x000000FF; //Gets the bit that contains alpha information

    return alpha;
  }