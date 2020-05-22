@Override
    public void actionPerformed(ActionEvent e) {
      x = circle.getX();
      int radius = circle.getRadius();
      int width = getWidth();
      if (x - radius <= 0 || x + radius >= width) {
        circle.turn(180);
      }
      circle.move();
      repaint();
    }
  }