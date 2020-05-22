import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXInitializer extends Application {

    private static Object barrier = new Object();

    @Override
    public void start(final Stage primaryStage) throws Exception {
        synchronized (barrier) {
            barrier.notify();
        }
    }

    public static void initialize() throws InterruptedException {
        Thread t = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                Application.launch(JavaFXInitializer.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        synchronized (barrier) {
            barrier.wait();
        }
    }
}