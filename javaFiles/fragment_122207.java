public void paintComponent(Graphics g){
    super.paintComponent(g);

    image.paintIcon(this, g, 0, 0);
    if (velX > 0) { // moving right
        image1.paintIcon(this, g, x, y);
    } else { // moving left
        image2.paintIcon(this, g, x, y);

    }
    t.start();
}