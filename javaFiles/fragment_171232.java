BufferedImage bImage= new BufferedImage(awtImage.getWidth(), awtImage.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g = bImage.createGraphics();
g.drawImage(awtImage, 0, 0, null);
g.dispose();

File outputfile = new File("saved.png");
ImageIO.write(bImage, "jpg", new File("code39.jpg"));