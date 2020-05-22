public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    int number = 15;
    int radiusSize = 225;

    Shape[] objects = new Shape[number];

    for(int i=0; i<number; i++){
        objects[i] = new Shape(radiuSsize - (i * 15), 250, 300);
        objects[i].draw(g2);
    }
}