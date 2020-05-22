Dimension d = txtCodigo.getSize();
BufferedImage img = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
Graphics g = img.getGraphics();
txtCodigo.printAll(g);
g.dispose();
// use ImageIO to write BufferedImage to file