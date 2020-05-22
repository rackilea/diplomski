public void setCircle(int r, int x_cordinate, int y_cordinate) {
        //Graphics g;
        c = new Ellipse2D.Double(x_cordinate - r, y_cordinate - r, r * 2, r * 2);
        System.out.println("set circle was called");
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(c);

    }