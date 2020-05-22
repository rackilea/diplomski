private class PanelListener extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
      x = e.getX();
      y = e.getY();
      if (circle.containsPoint(x, y)) selectedCircle = circle;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      // nothing here
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println("Mouse clicked");
      if (timer.isRunning()) {
        timer.stop();
      } else {
        timer.start();
      }
    }
  }