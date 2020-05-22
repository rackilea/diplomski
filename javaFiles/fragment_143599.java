BufferedImage bi = new BufferedImage(
    icon.getIconWidth(),
    icon.getIconHeight(),
    BufferedImage.TYPE_INT_RGB);
Graphics g = bi.createGraphics();
// paint the Icon to the BufferedImage.
icon.paintIcon(null, g, 0,0);
g.dispose();