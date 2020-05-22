Thread t = new Thread() {
    public void run() {
        MainWindow mW = new MainWindow();
        mW.run(null);
    }
};
t.start();