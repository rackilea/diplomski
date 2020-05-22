BufferedImage in = ImageIO.read(img);
BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);

Graphics2D g = newImage.createGraphics();
g.drawImage(in, 0, 0, in.getWidth(), in.getHeight(), null);
g.dispose();