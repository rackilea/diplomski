public class Circle {
    int x, y;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawCirlce(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }
}