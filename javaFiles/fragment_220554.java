public static void main(String[] args) {
    final BlockingQueue<BaseTask> tasks = new LinkedBlockingQueue<>();
    final BlockingQueue<BaseTask> queue2 = new LinkedBlockingQueue<>();
    for (int index = 0; index < 10; index++) {
        tasks.add(new BaseTask("Task1"));
        tasks.add(new BaseTask("Task2"));
        tasks.add(new BaseTask("Task3"));
    }
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    BaseTask task = tasks.take();
                    task.run();
                    task = tasks.take();
                    task.run();
                    task = tasks.take();
                    queue2.offer(task);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    BaseTask task = queue2.take();
                    task.run();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
    thread2.start();
    thread1.start();
}

private static class BaseTask implements Runnable {
    private final String name;

    public BaseTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " ["
                + Thread.currentThread().getName() + "]");
    }
}