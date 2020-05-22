public static class MyPanel extends JPanel {
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.draw(new Rectangle2D.Float(8,8, 128, 64));
    }

}