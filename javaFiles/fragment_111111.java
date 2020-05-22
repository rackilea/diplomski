public static class GameSaver {
    private final Runnable save = new Runnable() {

        @Override
        public void run() {
            saveGame();
        }
    };
    private static final ExecutorService executor = Executors.newFixedThreadPool(1);
    private final GameState state;

    public GameSaver(GameState state) {
        this.state = state;
    }

    public void save() {
        executor.submit(save);
    }

    public static void close() {
        executor.shutdown();
    }

    private void saveGame() {
        //save your game here
    }

}