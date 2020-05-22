public interface MyInterface {
    void method1();

    // void method2();
}

public class Main implements MyInterface {
    @Override
    public void method1() {
        System.out.println("method1 called");
    }

    public static void main(String... args) {
        new Main().method1();
    }
}