try {
    button.requestFocusInWindow();
    Robot bot = new Robot();
    Point pos = button.getLocationOnScreen();
    bot.mouseMove(pos.x + (button.getWidth() / 2), pos.y + (button.getHeight() / 2));
} catch (AWTException ex) {
    Logger.getLogger(TestRobot.class.getName()).log(Level.SEVERE, null, ex);
}