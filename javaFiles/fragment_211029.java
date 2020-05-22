private Executor exec = Executors.newCachedThreadPool();

// ...

@FXML
private void onRun() {
    exec.execute(() -> Utility.get().runBench(
        result -> Platform.runLater(console.appendText(result))));
}