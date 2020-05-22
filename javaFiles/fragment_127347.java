JComponent bordede = new JComponent() {
  private static final long serialVersionUID = 2222L;

  @Override
  protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     int width = getWidth();
     int height = getHeight();
     g.setColor(getBackground());
     g.fillRect(0, 0, width, height);
  }
};