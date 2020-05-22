class CustomerThread extends Thread {
    private static final AtomicInteger prevCustId = new AtomicInteger();
    private final int custId;

    CustomerThread(String name) {
        super(name);
        this.custId = prevCustId.incrementAndGet();
    }

    @Override
    public void run() {
        System.out.println(getName() + " executing with id: " + this.custId);
    }
}