class MyPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(degrees));
        //draw shape/image (will be rotated)
        g2d.setTransform(old);
        //things you draw after here will not be rotated
    }
}