public class Bullet extends Circle {
    private int startX;
    private int startY;

    public Bullet(int startX, int startY){
        super();
        this.startX = startX;
        this.startY = startY;
    }
    // I added some constructors.
    public Bullet(Circle circle, int startX, int startY){
        super(circle);
        this.startX = startX;
        this.startY = startY;
    }

    public Bullet(float x, float y, float radius, int startX, int startY){
        super(x, y, radius);
        this.startX = startX;
        this.startY = startY;
    }

    public Bullet(Vector2 position, float radius, int startX, int startY){
        super(position, radius);
        this.startX = startX;
        this.startY = startY;
    }

    //getters and setters here...
}