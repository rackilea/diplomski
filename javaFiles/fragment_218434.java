public class MyClass() {
    public MyClass() {
        this(1);
        System.out.printf("Calling MyClass()%n");
    }

    public MyClass(int a) {
        this(a, 2);
        System.out.printf("Calling MyClass(%d)%n", a);
    }

    public MyClass(int a, int b) {
        System.out.printf("Calling MyClass(%d, %d)%n", a, b);
    }
}