public class BoundingBox {

    public int x, y, width, height;

    public BoundingBox(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean contains(int x, int y) {
        return getX() == x && getY() == y;
    }
}