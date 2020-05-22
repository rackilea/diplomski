public class BoundingBox {

    public int x, y, width, height;

    public BoundingBox() {

    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public boolean contains(int x, int y) {
        return getX().equals(x) && getY().equals(y);
    }
}