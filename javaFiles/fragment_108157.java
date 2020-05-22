public class C {
    private objectA = new AImpl();
    private objectB = new BImpl();

    // Work with the objects here

    private class AImpl implements A {
        public int foo() {
            // ...
        }
    }

    private class BImpl implements B {
        public char foo() {
            // ...
        }
    }
}