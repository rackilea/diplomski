public class Rocket extends Rectangle {
    public boolean exploded = false;
    public float explosionAge = 0;

    public Rocket(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public Rocket(Rectangle rect) {
        super(rect);
    }
}