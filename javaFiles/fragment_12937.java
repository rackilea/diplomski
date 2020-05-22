MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
     public void mouseDragged(MouseEvent e) {
        Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
        ((JPanel)e.getSource()).scrollRectToVisible(r);
    }
 };
 panel.addMouseMotionListener(doScrollRectToVisible);