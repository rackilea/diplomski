public class TurtleFractal {

    public static void HilbertCurve(int n, Turtle turtle, double angle) {
        if (n <= 0) return;

        turtle.left(angle);
        HilbertCurve(n - 1, turtle, -angle);
        turtle.forward(1.0);
        turtle.right(angle);
        HilbertCurve(n - 1, turtle, angle);
        turtle.forward(1.0);
        HilbertCurve(n - 1, turtle, angle);
        turtle.right(angle);
        turtle.forward(1.0);
        HilbertCurve(n - 1, turtle, -angle);
        turtle.left(angle);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double s = Math.pow(2, n);
        Turtle fred = new Turtle();

        fred.worldCoordinates(0, 0, s, s);
        fred.up();
        fred.goTo(0.5, 0.5);
        fred.down();
        HilbertCurve(n, fred, 90.0);
    }
}