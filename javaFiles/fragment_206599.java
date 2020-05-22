class MyFileChooser extends JFileChooser {

    private static final Color COLOR_0 = new Color(200, 200, 255);
    private static final Color COLOR_1 = Color.BLUE;

    public MyFileChooser() {
        Component[] comps = getComponents();
        recursiveTransparent(comps);
    }

    private void recursiveTransparent(Component[] comps) {
        for (Component comp : comps) {
            if (comp instanceof JComponent && !(comp instanceof JList)) {
                ((JComponent) comp).setOpaque(false);
            }
            if (comp instanceof Container) {
                Component[] subComps = ((Container) comp).getComponents();
                recursiveTransparent(subComps);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Point p0 = new Point(0, 0);
        Point p1 = new Point(getWidth(), getHeight());
        Paint paint = new GradientPaint(p0 , COLOR_0, p1, COLOR_1);
        g2.setPaint(paint);
        g2.fillRect(0, 0, p1.x, p1.y);
    }
}