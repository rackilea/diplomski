public void testThread2() throws Exception {
    Table obj = new Table();//only one object
    ExecutorService taskExecutor = Executors.newFixedThreadPool(3);
    Random rand = new Random();
    final ArrayList<Integer> tasks = new ArrayList<>();
    tasks.add(1);
    tasks.add(2);
    tasks.add(3);
    tasks.add(4);
    for (Integer t: tasks) {
        taskExecutor.execute(() -> testThread2Runner(t, taskExecutor));
    }
    Thread.sleep(2000);
    taskExecutor.shutdown();
}

public static void testThread2Runner(int t, ExecutorService taskExecutor) {
    for (int j = 0; j< 5; j++) {
        System.out.println(j * 100 + t);
        try {
            Thread.sleep(rand.nextInt(300));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    if (t == 2) {
        taskExecutor.execute(() -> testThread2Runner(5, taskExecutor));
    }
}