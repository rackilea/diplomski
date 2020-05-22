BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g = (Graphics2D) target.getGraphics();
g.drawImage(source, 0, 0, null);
g.drawImage(logo, 20, 50, null);
File outputfile = new File("targetimage.png");
ImageIO.write(target, "png", outputfile);