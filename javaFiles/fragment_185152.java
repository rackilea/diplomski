private static final int BORDER = 1;
private static final int PADDING = 2;
private static final int SPACER = 5;

private static void draw(Graphics2D g, List<String> names) {
  FontMetrics metrics = g.getFontMetrics();
  Rectangle box = new Rectangle(1, 1, 0, 0);
  box.height = metrics.getHeight() + (PADDING * 2);
  g.setColor(Color.WHITE);
  for (String name : names) {
    box.width = metrics.stringWidth(name) + (PADDING * 2);
    g.drawString(name, box.x + BORDER + PADDING, PADDING + BORDER +
                                                    metrics.getHeight());
    g.drawRect(box.x, box.y, box.width, box.height);
    box.x += box.width + (BORDER * 2) + SPACER;
  }
}