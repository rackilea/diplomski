public static void main(String[] args) {
    myClass mc = new myClass(2);
    mc.init();
    ExecutorService te = Executors.newCachedThreadPool();
    te.submit(mc);
    te.submit(mc);
    te.shutdown();
}