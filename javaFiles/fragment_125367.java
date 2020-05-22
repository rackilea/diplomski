public class Test {
    public static void main(String[] args) {
        someMethod(10); // Fine; uses an integer literal
        int a = 10; 
        someMethod(a); // Fine; uses the value of a variable
        someMethod(int b); // Invalid syntax
    }

    public static void someMethod(int x) {
        System.out.println(x);
    }
}