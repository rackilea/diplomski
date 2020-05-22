class Test {

    public static void main(String[] args) {
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
            list.add(() -> System.out.println("Time : " + System.nanoTime() + " " + j));
        }
        list.parallelStream().forEach(r -> {
            System.out.println(Thread.currentThread().getName());
            r.run();
            System.out.println();
        });
    }
}