public class A {
    public String text;
    public String moreText;
    public static class B {
        public int i;
    }
}

//Create an instance of B:
A.B b = new A.B();
//property access for public properties requires no getters/setters from within or without the package
b.i = 5;
//Note that no instance of A is actually created