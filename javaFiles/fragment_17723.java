Action pressedAction = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        try {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (InterruptedException ex) {
            //handle the exception here
        }
    }
};