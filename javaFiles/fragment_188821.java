public class WebsiteOverviewController {
    @FXML
    public void handleScanInbox() {
        isScanning.set(true);

        thread = new Thread(mainApp::handleScanInbox);
        thread.start();
    }

    @FXML
    public void handlePauseScanInbox() {
        isScanning.set(false);
        mainApp.pause();
    }

    // Another handler for resuming...
}

public class MainApp {
    private final AtomicBoolean paused = new AtomicBoolean(false);

    public void handleScanInbox() {
        for (int i = 0; i < numberOfItems; i++) { // This could be a while loop
            synchronized (paused) {
                while (paused.get()) { // Using while so that it could re-wait in the case that the object was falsely notified
                    try {
                        pause.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Do whatever you need to do
        }
    }

    public void pause() {
        pause.compareAndSet(false, true);
    }

    public void resume() {
        synchronized (paused) {
            if (paused.get()) {
                paused.set(false);
                paused.notify();
            }
        }
    }
}