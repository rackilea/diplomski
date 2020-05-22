// register 'do somethings' as shutdown hook
 Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    public void run() {
       //do somethings
    }
 }, "Program existing..."));