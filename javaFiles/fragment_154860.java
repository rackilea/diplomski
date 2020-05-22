@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    ...
    for (Fireball ball : fireBalls) {
        ball.drawFireball(g);
    }
}