public class Incrdecr {

    static int x = 3;
    static int y = p(++x) * 5 / p(x--) + p(--x);

    private static int p(int i) {
        System.out.println("p(): " + i);
        return i;
    }

    public static void main(String[] args) {
        System.out.println("x is " + x);
        System.out.println("y is " + y);
    }
}