private WindowAdapter getWindowAdapter(JFrame frm) {
return new WindowAdapter() {
  @Override
  public void windowIconified(WindowEvent we) {
    frm.setState(JFrame.NORMAL);
  }
};