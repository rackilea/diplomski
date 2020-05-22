public class Test {
    private static int ctr = 0;
    public static void main(String[] args) {
        while (true) {
            method();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        }
    }

    private static void method() {
        System.out.println(ctr);
    }
}