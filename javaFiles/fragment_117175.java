class Point {
public int x;
public int y;

public Point(int x,int y) {
    this.x= x;
    this.y= y;
}


public void method() {
    System.out.println("this is parent");
}

}

public void print() {
    method();
}

public class ColorPoint extends Point{

public ColorPoint(int x, int y) {
    super(x, y);
}


@Override
public void method() {
    System.out.println("this is son");
}


public static void main(String[] args) {
    ColorPoint c = new ColorPoint(1, 2);
    c.print();

}
}