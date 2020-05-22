class imageComponent extends JComponent {

    Image img;
    int x, y;
    imageComponent() {
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                x = me.getX();
                y = me.getY();
                repaint();
            }
        });
        img = new ImageIcon(/* path to image */).getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, x, y, null);
    }
}