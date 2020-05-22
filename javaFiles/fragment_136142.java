Timer timer = new Timer(100, new ActionListener() {
  private final Robot robot = new Robot();

  public void actionPerformed(ActionEvent evt) {
    robot.mousePress(1);
    robot.mouseRelease(1);
    robot.keyPress(KeyEvent.VK_A);
  }
});