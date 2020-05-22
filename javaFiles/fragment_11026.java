public class Test {
    public static void main(String... args) {
        Test test = null;
        test.greeting(); // call with null reference
    }
    public static void greeting() {
        System.out.println("Hello World");
    }
}