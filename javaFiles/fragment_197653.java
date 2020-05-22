try
{
    Robot robot = new Robot();
    Thread.sleep(2000);
    robot.mouseMove(coordinates.getX()+100,coordinates.getY()-400); 
    Thread.sleep(2000);
    robot.mousePress( InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
}
catch (AWTException e)
{
    e.printStackTrace();
}