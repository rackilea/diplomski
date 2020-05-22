private void updateUI() throws InterruptedException {

    // actual work to update UI:
    FutureTask<Void> updateUITask = new FutureTask(() -> {

        // code to update UI...

    }, /* return value from task: */ null);

    // submit for execution on FX Application Thread:
    Platform.runLater(updateUITask);

    // block until work complete:
    updateUITask.get();
}