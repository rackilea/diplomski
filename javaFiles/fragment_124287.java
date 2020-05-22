private void dndToCenterOfObject(SelenideElement source, SelenideElement target)
        throws AWTException {
    Robot robot = new Robot();
    robot.setAutoDelay(150);
    int sourceX = getElementX(source);
    int sourceY = getElementY(source);
    int targetX = getElementX(target);
    int targetY = getElementY(target);
    mouseMove(sourceX, sourceY);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    mouseMove(targetX, targetY);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
}