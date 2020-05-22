class MainClass extends JPanel implements MouseListener {
  boolean clickedOnce = false;
  ArrayList<Line> lines = new ArrayList<Line>();
  int x, y;
  MainClass () {
    // init...
    addMouseListener(this);
  }
  // more MouseEvent methods
  public void mouseClicked(MouseEvent e) {
    if (!clickedOnce){
      x=e.getX(); 
      y = e.getY();
      clickedOnce = true;
    }
    else{
      lines.add(new Line(x,y,e.getX(), e.getY());
      clickedOnce = false;
      repaint();
    }
  }

  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    for (Line l: lines)
      g.drawLine(l.x1, l.y2, l.x2, l.y2);
  }

  private class Line {
    public int x1, y1, x2, y2;
    Line (int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
    }
  }
}