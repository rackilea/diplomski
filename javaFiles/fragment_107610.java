public class LVTest {
    @Override
    protected void finalize() {
        System.out.println("Finalized");
    }

    public static void main(String[] args) throws InterruptedException {
        {
            LVTest t = new LVTest();
        }
        System.out.println("GC!");
        System.gc();
        Thread.sleep(1000);
        System.out.println("GC!");
        System.gc();
        Thread.sleep(1000);
        System.out.println("GC!");
        System.gc();
        Thread.sleep(1000);
        System.out.println("Assign new var!");
        int a = 5;
        System.out.println("GC!");
        System.gc();
        Thread.sleep(1000);
        System.out.println("Finish");
    }
}