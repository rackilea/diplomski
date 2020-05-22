public class Outer {

    private class Inner {
        public void someMethod() {}
    }

    public Outer() {
        Inner in = new Inner();
        in.someMethod();
    }

}