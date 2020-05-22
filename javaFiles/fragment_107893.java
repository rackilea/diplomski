robot.keyPress(KeyEvent.VK_ALT);
robot.keyPress(KeyEvent.VK_C);

// possibly want a small Thread.sleep(...) here?

robot.keyRelease(KeyEvent.VK_C);
robot.keyRelease(KeyEvent.VK_ALT);