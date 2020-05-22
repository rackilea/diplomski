public enum HelloWorld implements Runnable {
    INSTANCE;

    @Override
    public void run() {
        System.out.println("Hello, world!");
    }
}

// ...
new Thread(HelloWorld.INSTANCE).start();