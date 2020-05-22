class GamePanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // added to paint child components
        g.drawString("asd", 5, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}