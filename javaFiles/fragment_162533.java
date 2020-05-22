public class Test {

    void f(Object o1, int i) {}
    void f(Object o1, Object o2) {}

    void test() {
        double d = 1.0;

        int i = 1;
        f(d, i); // ERROR!  Ambiguous
    }
}