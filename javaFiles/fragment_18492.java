public class Demo {

public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
        loop();
    }
}

private static void loop() {
    test(new TestMe() {

        @Override
        int getKey() {
            return 100;
        }
    });
    test(new TestMe() {

        @Override
        int getKey() {
            return 200;
        }
    });
}   
public abstract static class TestMe {
    abstract int getKey();
}   
public static void test(TestMe testMe) {
    System.out.println(testMe.getClass() + " " + testMe.getKey());
}   
}