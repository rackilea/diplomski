public class MakeMeWait {
    private static Object semaphore = new Object();

    public static void waitPlease() {
        semaphore.wait();
    }

    public static void wakePlease() {
        semaphore.notifyAll();
    }
}