public class NullRefStatic {

    public static void test() { // <-- static method
        System.out.println("It works");
    }

    public static void main(String... args) {
        NullRefStatic target = null;
        target.test(); // <-- Prints "It works"
    }
}