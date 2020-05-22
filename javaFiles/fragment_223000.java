public class Test {
    public static void main(String[] args) {
        long start = System.nanoTime();
        new Thread(() -> System.out.println("Thread took " +
                (System.nanoTime() - start) / 1e6 + " ms to start"))
                .start();
    }
}