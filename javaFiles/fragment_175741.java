public class FXApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Thread pausingAndIteratingThread = new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                } finally {
                    final int counter = i ;
                    Platform.runLater(() -> endIteration(counter));
                }
            }
        };

        pausingAndIterartingThread.start();
    }

    private void endIteration(int counter) {
        System.out.println("stopping: counter="+counter);
    }
}