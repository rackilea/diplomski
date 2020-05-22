public void updateGui() {

    Thread thread = new Thread(() -> {
        try {
            Platform.runLater(() -> doFirstStuff());
            Thread.sleep(1000);
            Platform.runLater(() -> doSecondStuff());
            Thread.sleep(1000);
            Platform.runLater(() -> doThirdStuff());
        } catch (InterrupedException exc) {
            // should not be able to get here...
            throw new Error("Unexpected interruption");
        }
    };
    thread.start();
}