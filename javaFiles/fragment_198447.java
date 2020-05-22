@FunctionalInterface
interface A {
    void printMessage();
}
interface B {
    default void printMessage() {
        A a = () -> System.out.println("A implementation (1)");
        a.printMessage();
    }
}
interface C {
    static void printMessage() {
        A a = () -> System.out.println("A implementation (2)");
        a.printMessage();
    }
}