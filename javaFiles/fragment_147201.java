public class QuadraticEquation {
    private int a, b, d;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.d = b * b - (4 * a * c);
    }

    public boolean hasOnlyOneSolution() {
        return d == 0;
    }

    public boolean noSolution() {
        return d < 0;
    }

    public int getSolution1() {
        return (int) (-b + Math.sqrt(this.d)) / (2 * a);
    }

    public int getSolution2() {
        return (int) (-b - Math.sqrt(this.d)) / (2 * a);
    }

    // + your main method
}