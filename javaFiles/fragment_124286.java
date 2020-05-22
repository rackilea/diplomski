private void mouseMove(int destinationLocationX, int destinationLocationY) throws AWTException {
    Robot robot = new Robot();
    Point mousePosition;
    robot.mouseMove(destinationLocationX/2, destinationLocationY/2);
    mousePosition = MouseInfo.getPointerInfo().getLocation();
    while (mousePosition.x != destinationLocationX && mousePosition.y != destinationLocationY) {
        mousePosition = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(destinationLocationX, destinationLocationY);
    }
}