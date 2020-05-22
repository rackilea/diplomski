import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class FXStarter extends Application {

    private static final AtomicBoolean startRequested = new AtomicBoolean(false);
    private static final CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void init() {
        Platform.setImplicitExit(false);
    }

    @Override
    public void start(Stage primaryStage) {
        latch.countDown();
    }

    /** Starts the FX toolkit, if not already started via this method,
     ** and blocks execution until it is running.
     **/
    public static void startFXIfNeeded() throws InterruptedException {
        if (! startRequested.getAndSet(true)) {
            new Thread(Application::launch).start();
        }
        latch.await();
    }
}