public class VmLimitTest {

    public static final int SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            byte[] a = new byte[SIZE * 1024 * 1024];
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}