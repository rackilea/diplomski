@Override 
public void paintComponent(Graphics g) {
    super.paintComponent(g);    // paints background

    Graphics2D g2 = (Graphics2D)g;
    g2.setStroke(new Stroke((int)returnslider));
    // rest of drawing.
}