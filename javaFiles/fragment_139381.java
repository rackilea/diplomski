public class Test {
    public int instanceVariable = 42;
    public void instanceMethod() {System.out.println("Hello!");}

    public static void staticMethod() {
        Test test = new Test();

        System.out.println(test.instanceVariable); // prints 42
        test.instanceMethod(); // prints Hello!
    }
}