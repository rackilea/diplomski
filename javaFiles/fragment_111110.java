private final Runnable save = new Runnable() {
    public void run() {
        saveTheGame();
    }
}
private final ExecutorService executor = Executors.newFixedThreadPool(1);