protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.RED);
    g2d.fillOval(stepX, stepY, 30, 30);
    startX = stepX;
    startY = stepY;
    if (stepX == endX && stepY == endY) {
        sliderTimer.stop();
    }
}