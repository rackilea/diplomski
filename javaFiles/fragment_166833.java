public void paint(final Graphics g) {

        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        Point p1 = SwingUtilities.convertPoint(button1, 0, 0, this);
        Point p2 = SwingUtilities.convertPoint(button2, 0, 0, this);

        g2.drawLine(p1.x, p1.y, p2.x, p2.y);
    }