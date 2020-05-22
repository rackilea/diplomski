Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
    ((Window) view).setVisible(false);
    Runtime.halt(0);
    }
    });