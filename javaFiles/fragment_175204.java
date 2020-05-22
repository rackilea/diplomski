SwingUtilities.invokeAndWait(new Runnable() {
  public void run() {
    a.setText(b.toString());
    a.setCaretPosition(b.length());
  }
}