FontRenderContext context = g2d.getFontRenderContext();
Font font = new Font("Arial", Font.BOLD, 48);
TextLayout txt = new TextLayout(text, font, context);

Rectangle2D bounds = txt.getBounds();
int x = (int) ((getWidth() - (int) bounds.getWidth()) / 2);
int y = (int) ((getHeight() - (bounds.getHeight() - txt.getDescent())) / 2);
y += txt.getAscent() - txt.getDescent();