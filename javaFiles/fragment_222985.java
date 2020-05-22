@Override
  public void start(final Stage stage) throws Exception {

    StackPane root = FXMLLoader.load(getClass().getResource("stage.fxml"));
    final Scene scene = new Scene(root);
    scene.widthProperty().addListener(new ChangeListener<Number>() {
      @Override
      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
        System.out.println("width: "+number+" -> "+number2);
      }
    });
    boolean resizable = true;
    stage.setResizable(resizable);
    stage.setTitle("Stage Resizable "+ resizable);
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();
  }