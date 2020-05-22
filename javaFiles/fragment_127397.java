JDesktopPane desktop = ...;
JPanel p = ...;

ComponentListener cl = new ComponentAdapter() {
  public void componentResized(ComponentEvent ce) {
    //reset your panel size here
  }
}

desktop.addComponentListener(cl);