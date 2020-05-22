webview.getEngine().getLoadWorker().stateProperty().addListener(
  new ChangeListener<Worker.State>() {
    @Override
    public void changed(
                ObservableValue<? extends Worker.State> observable,
                Worker.State oldValue, Worker.State newValue) {
      switch (newValue) {
        case SUCCEEDED:
        case FAILED:
        case CANCELLED:
          webview
            .getEngine()
            .getLoadWorker()
            .stateProperty()
            .removeListener(this);
      }


      if (newValue != Worker.State.SUCCEEDED) {
        return;
      }

      // Your logic here
      System.out.println("page loaded");
    }
  } );