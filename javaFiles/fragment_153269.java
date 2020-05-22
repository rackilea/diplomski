class MyPanel extends JPanel {

    private int oval_x = 150;
    private int oval_y = 150;

    public MyPanel() {
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(600, 150);
    }

    public void moveVerticallyBy(int delta) {
      oval_y += delta;
      repaint();
    }

    public void moveHorizontallyBy(int delta) {
      oval_x += delta;
      repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponents(g);
      g.setColor(Color.RED);
      g.fillOval(oval_x, oval_y, 150, 150);
    }
  }