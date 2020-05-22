public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    Rectangle rec = new Rectangle(50, 20, 50, 50);
    g.setColor(Color.BLUE);
    g.fillOval(x, y, 55, 55);
    g.fillRect(x + 23, y - 15, 10, 20);
    g.setColor(Color.RED);
    g.fillRect(rec.x, rec.y, rec.width, rec.height);

    if (shot && bullet != null) {
        g2d.setColor(Color.BLACK);
        g2d.fill(bullet);

        if (bullet.intersects(rec)) {
            g2d.drawString("collision!", 50, 20);
        }
    }
    g2d.dispose();

}