protected void paintComponent(Graphics g) {
...
        Rectangle bounds = this.getBounds();

        g.setColor(this.fillColor);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
...
    }