public class Test {
    public int instanceVariable = 42;
    public void instanceMethod() {System.out.println("Hello!");}

    public static void staticMethod() {
        System.out.println(instanceVariable); // compilation error
        instanceMethod(); // compilation error
    }
}