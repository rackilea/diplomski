try
{
     Robot robot = new Robot();
     robot.setAutoDelay(250);
     robot.keyPress(KeyEvent.VK_ALT);
     Thread.sleep(1000);
     robot.keyPress(KeyEvent.VK_S);
     robot.keyRelease(KeyEvent.VK_ALT);
     robot.keyRelease(KeyEvent.VK_S);
}
catch (AWTException e)
{
    e.printStackTrace();
}