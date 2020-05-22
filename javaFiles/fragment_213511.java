public class Final {
    static final Point p = new Point();
    public static void main(String[] args) {
        p = new Point(); // Fails
        p.b = 10; // OK
        p.a = 20; // Fails
    }
}

class Point {
    static final int a = 10;
    static int b = 20;
}