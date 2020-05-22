// The runnable instance
Runnable runnable = new Runnable() {
    public void run() {
        System.out.println("hello");
    }
};

// Anonymous Thread class with a custom run() method
new Thread(runnable) {
    public void run() {
        System.out.println("world");
    }
}.start();