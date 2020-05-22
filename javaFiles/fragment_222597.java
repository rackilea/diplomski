public class A {
    private A obj;
    public A() {
        obj = new A();  // This will become recursive creation of object.
                        // Thus resulting in StackOverflow 
    }
}