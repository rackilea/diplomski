img = new BufferedImage((int) Math.round(width), height, BufferedImage.TYPE_INT_ARGB);
g2d = img.createGraphics();
g2d.setFont(font);
fm = g2d.getFontMetrics();
g2d.setColor(Color.BLACK);
g2d.drawString(text, 0, fm.getAscent());
g2d.dispose();