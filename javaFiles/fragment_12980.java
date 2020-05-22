private void startBackgroundThread() {
    Thread thread = new Thread(() -> {
        doSomeComputationThatTakesFiveMinutes();

        // Do this on the EDT again...
        SwingUtilities.invokeLater(() -> {
            someLabel.setText("Finished");
        });
    });
    thread.start();
}