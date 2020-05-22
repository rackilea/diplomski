final MySwingWorker w = new MySwingWorker();
Runnable r = new Runnable() {
    public void run() {
        // do something with w.get()
    }
};
w.setRunnable(r);
w.execute();