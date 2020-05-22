public class FakeTransperencyButton extends JButton {

    private float alpha = 0;

    public FakeTransperencyButton(String text) {
        super(text);
        setOpaque(false);
        setBackground(Color.RED);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                alpha = 0.4f;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                alpha = 0f;
                repaint();
            }

        });
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    public float getAlpha() {
        return alpha;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(getAlpha()));
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
        super.paintComponent(g);
    }

}