Thread t = new Thread(new Runnable(
    public void run() {
        copyFile();
    }
));
t.start();