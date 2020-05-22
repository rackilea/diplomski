@FXML
public void handleScanInbox() {
    isScanning.set(true); // Not sure if you still need this

    if (thread == null) {
        thread = new Thread(mainApp::handleScanInbox);
        thread.start();
    }
    else if (thread.isAlive()) {
        mainApp.resume();
    }
}