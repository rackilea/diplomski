public class CirclePane extends JPanel {

    private Point p = new Point(100, 100);

    public CirclePane() {
        MouseAdapter mouseHandler = new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                p = e.getPoint();
                repaint();
            }

        };
        addMouseMotionListener(mouseHandler);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawOval(p.x - 50, p.y - 50, 100, 100);
        g2d.dispose();
    }

}