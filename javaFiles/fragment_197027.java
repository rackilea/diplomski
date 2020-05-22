@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.red);
    g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
}