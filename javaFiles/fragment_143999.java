class Carpaint extends SimpleSprite {
    public Carpaint(float x, float y, float dx, float dy) {
        super(x, y, dx, dy);
    }
    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.pink);
        g2d.fillRect((int) x, (int) y, 40, 60);
        g2d.setColor(Color.black);
        g2d.drawRect((int) x, (int) y, 40, 60);
        g2d.drawRect((int) x + 10, (int) y + 10, 20, 40);
        g2d.fillRect((int) x-5, (int) y, 5, 15);
        g2d.fillRect((int) x + 40, (int) y, 5 , 15);
        g2d.fillRect((int) x - 5, (int) y + 45, 5, 16);
        g2d.fillRect((int) x + 40, (int) y + 45, 5, 16);
    }
}