BufferedImage source = ImageIO.read(new File("imgToDrawOnto.png"));
BufferedImage newImage = new BufferedImage(
    source.getWidth(), 
    source.getHeight(), 
    BufferedImage.TYPE_INT_ARGB);

Graphics2D g = (Graphics2D)newImage.getGraphics();

g.drawImage(source, 0, 0, null);
g.drawImage(circleImg, 100, 100, null);