class BullsEye {
    public void draw(Graphics2D g2, int radius, int xCenter, int yCenter) {
        while (radius >= 5) {
            g2.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
            radius -= 15;
        }
    }
}