public BufferedImage getBufImg()
    {
      BufferedImage newImg = new BufferedImage(getSize().getWidth(), getSize().getHeight(), BufferedImage.TYPE_INT_ARGB); //Create a new buffered image the right size
      Graphics2D g2d = newImg.createGraphics();
      g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

      g2d.drawImage(bufImg, 0, 0, getSize().getWidth(), getSize().getHeight(), null);
      g2d.dispose();

      return newImg;
    }