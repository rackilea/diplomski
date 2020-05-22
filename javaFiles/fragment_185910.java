class Tile {
    public int value;
    public Boolean collided;

    public Tile(int value) {
        this.value = value;
        collided = false;
    }

    public Tile attemptMerge(Tile target) {
        if (target.value == value) {
            Tile t = new Tile(value * 2);
            t.collided = true;
            return t;
        } else {
            return null;
        }
    }

    public void reset() {
        value = 0;
        collided = false;
    }
}