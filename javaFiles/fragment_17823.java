public class JFrameCreator implements Runnable {

    private final Runnable onFinished;

    public JFrameCreator(Runnable onFinished) {
        this.onFinished = onFinished;
    }

    @Override
    public void run() {
        // do your work...
        Platform.runLater(onFinished); // to communicate to JavaFX Application
                                       // Thread that JFrameCreator is complete
    }

}