new Thread() {
    public void run() {
        System.out.println("Thread: " + getName());
        System.out.println("hello");
    }
}.start();