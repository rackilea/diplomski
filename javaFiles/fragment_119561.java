public class Test {

    public static void main(String[] args) throws InterruptedException {

        int count = 2;
        ExecutorService ex = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 1; i <= count; i++)
            ex.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println("Starting thread "+ name);
                try { Thread.sleep(1000); } catch (Exception e) { }
                System.out.println("Pre-Notification work completed "+ name);
                latch.countDown();
                try { Thread.sleep(1000); } catch (Exception e) { }
                System.out.println("Post-Notification Work Completed"+ name);
            }
        );
        latch.await();
        //ex.shutdown();
        //ex.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Finishing Execution");
    }
}