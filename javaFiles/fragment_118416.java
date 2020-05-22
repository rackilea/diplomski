Graphics2D g = ...;
Point2D loc = ...;
Font font = Font.getFont("Helvetica-bold-italic");
FontRenderContext frc = g.getFontRenderContext();
TextLayout layout = new TextLayout("This is a string", font, frc);
layout.draw(g, (float)loc.getX(), (float)loc.getY());

Rectangle2D bounds = layout.getBounds();
bounds.setRect(bounds.getX()+loc.getX(),
              bounds.getY()+loc.getY(),
              bounds.getWidth(),
              bounds.getHeight());
g.draw(bounds);