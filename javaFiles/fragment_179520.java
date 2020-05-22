public class Test {

    public static void main(String[] args) {
        Object object = new Clazz();

        method(object);
    }

    static class Clazz implements Interface1, Interface2 {}

    interface Interface1 {}

    interface Interface2 {}

    private static void method(Object o)     {}
    private static void method(Interface1 i) {}
    private static void method(Interface2 i) {}
}