someButton.addActionListener(e -> {
    startBackgroundThread();
});

private void startBackgroundThread() {
    Thread thread = new Thread(() -> {
        doSomeComputationThatTakesFiveMinutes();
        someLabel.setText("Finished");              // WARNING - see notes below!
    });
    thread.start();
}