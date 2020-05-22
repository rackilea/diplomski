static class MyPanel extends JPanel {
    public MyPanel() {
        super();
        setOpaque(true);
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        // let the component be painted "natural"
        super.paintComponent(g);
        // Do custom painting
        g.setColor(Color.WHITE);
        g.fillRect(50, getHeight() / 2, 20, 120);
    }
}