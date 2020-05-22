public class Block extends GameObject {

    private boolean animate = true;

    Texture tex = Game.getInstance();
    private int type;

    public Block(float x, float y, int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
    }

    public void tick(LinkedList<GameObject> object) {
        bAnimate.runAnimation();
    }

    public void render(Graphics g) {
        if (type == 0) g.drawImage(tex.red_block[0], (int)x, (int)y, null); // Red Block
        if (type == 1) g.drawImage(tex.green_block[0], (int)x, (int)y, null); // Blue Block
        if (type == 2) g.drawImage(tex.blue_block[0], (int)x, (int)y, null); // Green Block
        if (type == 3) g.drawImage(tex.yellow_block[0], (int)x, (int)y, null); // Yellow Block
        if (type == 4) g.drawImage(tex.orange_block[0], (int)x, (int)y, null); // Orange Block
        if (type == 5) g.drawImage(tex.pink_block[0], (int)x, (int)y, null); // Pink Block
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

}