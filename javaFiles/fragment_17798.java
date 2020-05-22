Thread thread = new Thread() {
    public void run() {
        try {
            Process proc = Runtime.getRuntime().exec("sleep 5");
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
};
thread.start();  //start thread in background
synchronized (thread) {
    try {
        thread.wait(1000L);  //your timeout
        if (thread.isAlive()) {
            System.out.println("interrupting");
            thread.interrupt();  //interrupt the thread
        }
    } catch (Exception e) {
        System.out.println("interrupted");
    }
}