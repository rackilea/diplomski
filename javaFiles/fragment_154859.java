List<Fireball> fireBalls;
...
private class Fireball {

    Image fireball;
    int x = 150;
    int y = 125;

    public Fireball(Image image) {
        fireball = image;
    }

    public void drawFireball(Graphics g) {
        g.drawImage(fireball, x, y, 50, 50, null);
    }
}