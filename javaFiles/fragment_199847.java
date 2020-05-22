public class GameLoop {
    private static final int FPS = 60;

    public static void main(String[] args) {
        new GameLoop().startGame();
    }

    private void startGame() {
        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updateGame();
            }
        }, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
    }

    private void updateGame() {
        System.out.println("game updated");
        // the game code
    }
}