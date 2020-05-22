@Override
public void paintComponent(Graphics g) {

    super.paintComponent(g);
    g.setColor(Color.green);
    drawTree(g, 400, 750, 200, Math.toRadians(-90), Math.toRadians(45), slideVal);
}