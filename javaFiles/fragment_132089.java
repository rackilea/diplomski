Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        runTCCmd(tc.createJavaClass());
    }
});
t.start();
t.join();