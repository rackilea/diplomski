//Navigating to the site
driver.get("http://www.google.com");

//To get the focus on the searchbox (NOT ENTERING ANYTHING)
driver.findElement(By.id("gbqfq")).sendKeys("");

Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_CAPS_LOCK);
robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
robot.keyPress(KeyEvent.VK_H);
robot.keyRelease(KeyEvent.VK_H);
robot.keyPress(KeyEvent.VK_E);
robot.keyRelease(KeyEvent.VK_E);
robot.keyPress(KeyEvent.VK_L);
robot.keyRelease(KeyEvent.VK_L);
robot.keyPress(KeyEvent.VK_L);
robot.keyRelease(KeyEvent.VK_L);
robot.keyPress(KeyEvent.VK_O);
robot.keyRelease(KeyEvent.VK_O);
robot.keyPress(KeyEvent.VK_CAPS_LOCK);
robot.keyRelease(KeyEvent.VK_CAPS_LOCK);