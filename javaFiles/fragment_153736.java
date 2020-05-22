public class Parent {
    public static void main(String... args) {
        hello(null); // takes `Child`
    }

    public static void hello(Parent _) {
        System.out.println("SuperClass");
    }

    public static void hello(Child _) {
        System.out.println("SubClass");
    }
}

class Child extends Parent {

}