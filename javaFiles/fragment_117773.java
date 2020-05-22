Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    @Override
    public void run() {
    System.out.println("shutdown application");

    }
}));