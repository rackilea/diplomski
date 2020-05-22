interface AppleJava {
    default void test() {
        System.out.println("AppleJava.test()");
    }

    interface GreenJava extends AppleJava {
        @Override
        default void test() {
            AppleJava.super.test();
            System.out.println("GreenJava.test()");
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        new AppleJava() {}.test();
        new AppleJava.GreenJava() {}.test();
    }
}