class MyDrawPanel extends JPanel {
    private Color startColor;
    private Color endColor;

    // And setters or some other way
    // to randomise the colors

    public void paintComponent (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(0, 0, this.getWidth(), this.getHeight());

    }
}