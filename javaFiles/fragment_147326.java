class CustomerThread extends Thread {
    private static int customerID = 0;

    private static ThreadLocal tl = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return ++customerID;
        }
    };

    CustomerThread(String name) {
        super(name);
    }

    public void run() {
        tl.set(tl.get());
        System.out.println(Thread.currentThread().getName() + "....executing with customer id :" + tl.get());
    }
}