ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("res/icons/toolbar/" + iconName));

  BufferedImage ax = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
  BufferedImage bx = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);

  Graphics g = ax.createGraphics();
  new ImageIcon(icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)).paintIcon(null, g, 0, 0);
  g.dispose();

  g = bx.createGraphics();
  icon.paintIcon(null, g, 0, 0);
  g.dispose();

  BaseMultiResolutionImage baseMultiResolutionImage = new BaseMultiResolutionImage(ax, bx);
  return new ImageIcon(baseMultiResolutionImage);