@FunctionalInterface
interface A {
    void printMessage();
}
interface B extends A {
    @Override
    default void printMessage() {
        A a = () -> System.out.println("A implementation (1)");
        a.printMessage();
    }
}
interface C extends A {
    // compilation error
    static void printMessage() {
        A a = () -> System.out.println("A implementation (2)");
        a.printMessage();
    }
}