public class CirclePanel extends JPanel {
    private static final Stroke DASHED = new BasicStroke(1,
            BasicStroke.CAP_BUTT, 
            BasicStroke.JOIN_BEVEL, 
            0, new float[]{6}, 0);

    public Color oldCircleColor = Color.BLUE;
    public Color newCircleColor = Color.RED;
    public Color backgroundColor = Color.LIGHT_GRAY;

    private final List<Circle> oldCircles = new ArrayList<>();
    private Circle newCircle = null;
    private int mouseX = 0;
    private int mouseY = 0;

    private class MouseHelper implements MouseListener, MouseMotionListener {
        @Override public void mouseMoved(MouseEvent e) {}
        @Override public void mouseClicked(MouseEvent e) {}
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
            if (newCircle == null) {
                newCircle = new Circle(mouseX, mouseY, 0);
            } else {
                int dX = newCircle.x - mouseX;
                int dY = newCircle.y - mouseY;
                newCircle.radius = (int) Math.sqrt(dX*dX + dY*dY);
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (newCircle != null) {
                oldCircles.add(newCircle);
                newCircle = null;
                repaint();
            }
        }

    }

    public CirclePanel() {
        MouseHelper helper = new MouseHelper();
        addMouseListener(helper);
        addMouseMotionListener(helper);
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(oldCircleColor);
        for (Circle c : oldCircles) {
            drawCircle(g, c);
        }

        Circle c = newCircle;
        if (c != null) {
            g.setColor(newCircleColor);
            drawCircle(g, c);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setStroke(DASHED);
            g2.drawLine(c.x, c.y, mouseX, mouseY);
            g2.dispose();
        }
    }

    private void drawCircle(Graphics g, Circle c) {
        // note: drawOval takes top-left corner and diameter, NOT center and radius
        g.drawOval(c.x - c.radius, c.y - c.radius, c.radius * 2, c.radius * 2);
    }
}