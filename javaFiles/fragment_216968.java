webEngine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
  if (newState == Worker.State.FAILED) {
    doOnError();
    return;
  }
  doOnSuccess();
});

webEndgine.load("example.com");