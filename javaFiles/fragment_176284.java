public class Rectangle {
private Point origin;
private int width, height;

public Rectangle() {
    this(new Point(0,0), 1, 1);
}
public Rectangle(int width, int height) {
    this(new Point(0,0), width, height);
}

//One more constructor just for fun
public Rectangle(int x, int y, int width, int height) {
    this(new Point(x, y), width, height);
}

//Note: All of the constructors are calling this method via this(Point, int, int)
public Rectangle(Point origin, int width, int height) {
    this.origin = origin;
    this.width = width;
    this.height = height;
}
...
}