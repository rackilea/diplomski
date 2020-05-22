class MyPanel extends JPanel {

    private Point posy = new Point(0, 0);

    public Point getPosy() {
        return posy;
    }

    public void move() {
        Point posy = getPosy();
        posy.x++;
        posy.y++;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(posy.x, posy.y, 40, 40);
    }
}