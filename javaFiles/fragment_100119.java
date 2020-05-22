addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        // Again, ideally don't access variables directly
        Point playerPosition = new Point(player.x, player.y);
        Point touched = new Point(e.getX(), e.getY());

        // You'd need to put this somewhere else if you use an existing Point
        // type.
        double angle = touched.getAngleTowards(playerPosition);
        // This method would have all the trigonometry.
        Velocity velocity = Velocity.fromAngleAndSpeed(angle, 5);

        bullets.add(new Bullet(playerPosition, velocity));
    }
}