// imports here

public class Rect2 {
    private Color myColor = Color.RED;
    private int x = 10;
    private int y = x;
    private int width = 200;
    private int height = width;

    public Rect2() {
        // default constructor
    }

    public Rect2(Color myColor, int x, int y, int width, int height) {
        this.myColor = myColor;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // method used to allow the rectangle to be drawn
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillRect(x, y, width, height);
    }

    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // more setters and some getters if need be

}