myFrame.addComponentListener(new ComponentAdapter() {
  public void componentResized(ComponentEvent ev) {
    progressBar.setPreferredSize(new Dimension(getWidth() - 100, 50));
    revalidate();
    repaint();
  }
});