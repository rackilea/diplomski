new Thread() {
    public void run() {
        new ServerSocket(123456).accept();
        System.exit(0);
    }
}.start();