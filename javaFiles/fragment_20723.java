class Test {

    public static void main(String[] args) throws InterruptedException {
        List<Runnable> list = new LinkedList<>();
        list.add(() -> {
            try {
                System.out.println("Long sleep - " + Thread.currentThread().getName());
                Thread.sleep(10000);
                System.out.println("Time : " + System.nanoTime() + " " + "Slow task");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 1000; i++) {
            int j = i;
            list.add(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Time : " + System.nanoTime() + " " + j);
                System.out.println();
            });
        }


        final ExecutorService stealingPool = Executors.newWorkStealingPool();
        list.forEach(stealingPool::execute);
        stealingPool.shutdown();
        stealingPool.awaitTermination(15, TimeUnit.SECONDS);
    }
}