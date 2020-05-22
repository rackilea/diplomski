webView.getEngine().getLoadWorker().stateProperty().addListener(
  (ObservableValue<? extends Worker.State> observable,
    Worker.State oldValue,
    Worker.State newValue) -> {
    if( newValue != Worker.State.SUCCEEDED ) {
      return;
    }

    // Your logic here
  } );