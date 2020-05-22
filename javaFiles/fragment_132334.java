@Override
public void actionPerformed (ActionEvent arg0) {

    Point p = new Point(0, 0);
    SwingUtilities.convertPointToScreen(p, JMainPanel);
    Rectangle screenBounds = new Rectangle(p.x, p.y, JMainPanel.getSize().width, JMainPanel.getSize().height);

    try {
        Robot robot = new Robot();
        BufferedImage screenCapture = robot.createScreenCapture(screenBounds);

        jImage.getGraphics().drawImage(screenCapture, 0, 0, jImage);
    } catch (AWTException e) {
        e.printStackTrace();
    }
}