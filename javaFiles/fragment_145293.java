ImageIcon ico = new ImageIcon("/path/to/your/image.png");
Image img = ico.getImage();
BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
Graphics g = bi.createGraphics();
g.drawImage(img, 0, 0, yourLabel.getWidth(), yourLabel.getHeight(), null);
IconImage newIco = new IconImage(bi);
yourLabel.setIcon(newIco);