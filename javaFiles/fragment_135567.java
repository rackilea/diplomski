Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    public void run() {
        try {
            finalize();
        } catch (Throwable e) {
            System.out.println(e);
        }
    }
}));