public class Test {

    void f(Object o1, int i) {
        System.out.println("1");
    }
    void f(Object o1, Object o2) {
        System.out.println("2");
    }

    void test(boolean b) {
        String s = "string";
        double d = 1.0;
        int i = 1;

        f(b ? s : d, i); // ERROR!  Ambiguous
    }

    public static void main(String[] args) {
        new Test().test(true);
    }
}