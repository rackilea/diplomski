class RunnableTest implements Runnable {
    static String shared = "Shared static data";
    String instance = "Instance data";
    @Override
    public void run() {
        // TODO Auto-generated method stub

        System.out.println(Thread.currentThread().getName() + " " + shared + " " + instance);
    }
    RunnableTest(String instance) {
        this.instance = instance;
    }
    public static void main(String[] args) {
        RunnableTest r1 = new RunnableTest("instance1");
        Thread t1 = new Thread(r1, "first");
        t1.start();
        Thread t2 = new Thread(r1, "second");
        t2.start();
    }
}