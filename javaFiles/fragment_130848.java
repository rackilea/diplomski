public class MyClass extends ParentClass {
    private int _a,_b,_c;

    public MyClass(String input) {
        this(calculateA(input));
    }

    private MyClass(int a) {
        this(a, calculateB(a), calculateC(a));
    }

    private MyClass(int a, int b, int c) {
        super(b + c);
        this._a = a;
        this._b = b;
        this._c = c;
    }

    private static int calculateA(String text) {
        try {Thread.sleep(1000);} catch (Exception e) {}  // expensive ;-)
        return text.length();
    }

    private static int calculateB(int a) { /* ... */ }
    private static int calculateC(int a) { /* ... */ }
}