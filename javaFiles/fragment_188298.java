private JFrame myFrame;

public void run() {
  myFrame = new GUI();
  myFrame.setVisible(true);
}

public void hide() {
  myFrame.setVisible(false);
}