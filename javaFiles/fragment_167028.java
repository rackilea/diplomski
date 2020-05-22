class A {
    public static void hello() { System.out.println("Hello World"); }

    public static void main(String... args) {
        A a = null;
        a.hello();
        System.out.println("a is an A is " + (a instanceof A)); // prints false.
    }
}