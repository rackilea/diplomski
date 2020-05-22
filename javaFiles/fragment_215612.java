BufferedImage image = ImageIO.read(file);
int whiteSpaceHeight = 20;
BufferedImage result = new BufferedImage(image.getWidth(),
      image.getHeight()+whiteSpaceHeight, image.getType());
Graphics graphics = result.getGraphics();
graphics.drawImage(image, 0, whiteSpaceHeight, null);
graphics.drawString(textToAdd, 0, whiteSpaceHeight/2);