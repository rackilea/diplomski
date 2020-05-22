try {
    Robot robot = new Robot();
    if (spaceBarPressed) {
        try {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (InterruptedException ex) {
            //handle the exception here
        }
    }
} catch (AWTException e) {
    //handle the exception here
}