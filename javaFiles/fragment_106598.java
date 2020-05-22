public class App {
    public void calAreaSquare(double a) {
        System.out.println("Area of square is Side x Side : " + a * a);
    }

    public void calAreaRectangle(double a, double b) {
        System.out.println("Area of rectangle is length x width" + a * b);
    }

    public void calAreaCircle(double r) {
        double area = (Math.PI * r * r);
        System.out.println("Area of circle is Radius x Radius x PI : " + area);
    }

    public static void main(String[] args) {

        App app = new App();

        app.calAreaCircle(5);
    }
}