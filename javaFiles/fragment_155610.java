public class MyClass {

    public static int ones(int x) {
        if (x <= 1) return x;

        return x % 2 + ones(x >> 1);
    }

    public static void main(String args[]) {
        int x = 63;

        System.out.println("Ones in " + x + " : " + ones(x));
    }
}