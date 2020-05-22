@Override
 public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
     Graphics2D graphics = (Graphics2D) g;
     graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     if (c.getParent() != null) {
         Color bc = g.getColor();
         g.setColor(c.getParent().getBackground());
         for (int r = 0; r<radius;r++){
            g.drawRoundRect(x, y, width - 1, height - 1, r, r);
         }
         g.setColor(bc);
     }
     g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
 }