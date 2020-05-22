classs MyPanel extends JPanel {
    Image image;

    public void repaintBackground(Image image) {
        this.image = image;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image);
    }
}