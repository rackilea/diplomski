Graphics2D g;
    Dimension dimFrame;
    int x, y;
    ChartPanel() {
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(700, 500));
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void paint(Graphics g2) {
        super.paint(g2);
        g = (Graphics2D) g2;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        dimFrame = getSize();
        g.clearRect(0, 0, dimFrame.width, dimFrame.height);//clears previous drawings
        g.setColor(Color.BLACK);
        g.drawLine(x - 10, y, x + 10, y);
        g.drawLine(x, y - 10, x, y + 10);
    }