@Override
    protected void paintComponent(Graphics g) {
        Rectangle rect = getVisibleRect();
        g.drawImage(image.getImage(), rect.x, rect.y, rect.width, rect.height, this);
        super.paintComponent(g);
    }