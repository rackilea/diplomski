public class Test {
    public static void main(String[] args) {
        new Sub().test();
    }
}
class Base {
    int b;
    Base() {
        test();
        this.b = 1;
    }
    void test() {
        System.out.println("Hello from Base. b = " + this.b);
    }
}
class Sub extends Base {
    int s;
    Sub() {
        test();
        this.s = 2;
    }
    @Override
    void test() {
        System.out.println("Hello from Sub. b = " + this.b + ", s = " + this.s);
    }
}