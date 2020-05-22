public class Test {
    private int a;
    private int b;
    private int c;

    public Test(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String count() {
        return count(a, b, c);
    }

    public static String count(int a1, int b1, int c1) {
        String solution;
        solution = Integer.toString(a1 + b1 + c1);
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(Test.count(1, 2, 3));
        Test t1 = new Test(1, 2, 3);
        System.out.println(t1.count());
    }
}