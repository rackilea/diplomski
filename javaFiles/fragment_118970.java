class MyComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.draw3DRect(10, 10, 50, 50, true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}