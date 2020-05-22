public class Main implements MyInterface {    
    public void method1() {
        System.out.println("method1 called");
    }

    public void method2() {
        System.out.println("method2 called");
    }

    public static void main(String... args) {
        new Main().method1();
    }
}