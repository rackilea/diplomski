class GridPanel extends JPanel {
    GridPanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode("#0232ac"));
        g.fillRoundRect(100, 50, 300, 600, 50, 50);
        g.setColor(Color.white);
        g.drawString("TitleonRect", 220, 80);
    }
}