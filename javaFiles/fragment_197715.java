public void sayWorld(Graphics2D g2D, int x, int y, boolean shear) {
      final String txt = "Hello World!";

      // gradient color from blue to red
      GradientPaint gp = new GradientPaint((float)x, (float)y, Color.blue,
                             x+100, y+20, Color.red);
      g2D.setPaint(gp); 
      if (shear) g2D.shear(-0.5,0.0);
      else       g2D.shear(+0.5, 0);
      g2D.drawString(txt, x, y);

      FontRenderContext frc = new FontRenderContext(null,false,false);

      TextLayout tl = new TextLayout(txt, font, frc);
      AffineTransform textAt = new AffineTransform();
      //textAt.translate(0, (float)tl.getBounds().getHeight());
      textAt.translate(x,y); 
      //textAt.shear(-0.5,0.0);

      Shape outline = tl.getOutline(textAt); 
      g2D.setColor(Color.yellow);
      BasicStroke wideStroke = new BasicStroke(2);
      g2D.setStroke(wideStroke); 
      g2D.draw(outline);
  }