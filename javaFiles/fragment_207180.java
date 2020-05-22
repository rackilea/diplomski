class SomeClass {
    static void staticPrint() {
//  ^^^^^^^^^^^ static
        System.out.println("Hello from static");
    }

    void instancePrint() {
//  ^^^^ not static
        System.out.println("Hello from non-static");
    }
}