public BufferedImage More ...getSubimage (int x, int y, int w, int h) {
        return new BufferedImage (colorModel,
                                  raster.createWritableChild(x, y, w, h,
                                                             0, 0, null),
                                  colorModel.isAlphaPremultiplied(),
                                  properties);
   }