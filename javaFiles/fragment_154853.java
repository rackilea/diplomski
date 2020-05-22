private boolean openingboard() {
    Robot robot = new Robot();
    Color color3 = new Color(108, 25, 85);
    Rectangle rect = new Rectangle(0, 0, 1365, 770);
    BufferedImage image = robot.createScreenCapture(rect);
    for(int x = 0; x < rectangle.getWidth(); x++) {
        for(int y = 0; y < rectangle.getHeight(); y++) {
            if(image.getRGB(x, y) == color3.getRGB())
                return true;
        }
    }

    return false;
}