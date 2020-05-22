webView.getEngine().getLoadWorker().stateProperty().addListener(
  new ChangeListener<Worker.State>() {
  @Override
  public void changed(
    ObservableValue<? extends Worker.State> observable,
    Worker.State oldValue, Worker.State newValue ) {

    if( newValue != Worker.State.SUCCEEDED ) {
      return;
    }

    // Your logic here
  }
} );