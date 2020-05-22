public void paintControl(PaintEvent e) {

    Canvas c = ((Canvas) e.getSource());

    Point pos = c.toDisplay(c.getLocation());

    Point relativePos = new Point(e.x - pos.x, e.y - pos.y);

    int x = Display.getCurrent().getCursorLocation().x + relativePos.x + 10;
    int y = Display.getCurrent().getCursorLocation().y + relativePos.y + 10;

    e.gc.drawOval(x, y, 20, 20);
}