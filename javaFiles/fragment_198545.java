class BullsEyeComponent extends JComponent {
    BullsEye bullsEye = new BullsEye();

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int radius = (int) (Math.min(getWidth(), getHeight()) * 0.9 / 2);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        bullsEye.draw(g2, radius, xCenter, yCenter);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}