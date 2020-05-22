static class ThreadDemo extends Thread {
    private String threadName;
    PrintDemo PD;

    ThreadDemo (String name, PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    @Override
    public void run() {
        synchronized (PD) {
            PD.printCount();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
    }
}