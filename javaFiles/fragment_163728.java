public class Test {

    private static void privateMethod() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @Override public void run() {
                privateMethod();
            }
        };
        runnable.run();
    }
}