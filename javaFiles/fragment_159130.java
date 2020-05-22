class Painter extends MouseAdapter implements MouseMotionListener
  {
    Point start, end;

    Point oldStart, oldEnd;

    int startX, startY, oldX, oldY, oldWidth, oldHeight;

    public void mousePressed(MouseEvent e)
    {
      start = e.getPoint();
      oldX = startX;
      oldY = startY;
      startX = e.getX();
      startY = e.getY();
      status.setText(String.format("Mouse start: " + start));

    }

    public void mouseDragged(MouseEvent e)
    {
      Graphics2D gc = (Graphics2D)canvas.getGraphics();
      end = e.getPoint();
      gc.setColor(new Color(128, 218, 255));
      gc.drawOval(oldX, oldY, oldWidth, oldHeight);
      oldX = startX;
      oldY = startY;
      oldWidth = e.getX();
      oldHeight = e.getY();
      gc.setColor(Color.BLACK);
      gc.drawOval(startX, startY, e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e)
    {
      end = e.getPoint();
      status.setText(String.format("Mouse end: " + end));
      Graphics2D gc = (Graphics2D)canvas.getGraphics();
      oldX = 0;
      oldY = 0;
      oldWidth = 0;
      oldHeight = 0;

    }
  }