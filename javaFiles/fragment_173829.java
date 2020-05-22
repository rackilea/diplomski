Runnable myRunnable = new Runnable() {
    public void run() {
        System.out.println("Hello");
    }
};
new Thread(myRunnable).start();