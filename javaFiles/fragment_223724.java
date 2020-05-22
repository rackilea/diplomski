public class MyClass {
    String name;

    public MyClass(String name) {
        name = name; // Obviously doesn't work
        this.name = name;  // Now it works.
    }
}