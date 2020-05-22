class PolyPanel extends JPanel {
    protected void poly(Graphics g) {
       ...  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        poly(g);
    }
}