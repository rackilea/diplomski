addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        int pressedX = e.getX();
        int pressedY = e.getY();

        Bullet bullet = new Bullet(player.x, player.y);
        double angle = Math.atan2((pressedY - player.y), (pressedX - player.x));
        bullet.dx = Math.cos(angle)*5;
        bullet.dy = Math.sin(angle)*5;
        bullets.add(bullet);
    }
}