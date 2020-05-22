public class Start extends Application {

  public static void main(String[] args)  {
      Application.launch(Start.class,"myClass");
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Label label = new Label("Name:");
    TextField textField = new TextField();
    HBox hBox = new HBox();
    hBox.getChildren().addAll(label,textField);
    hBox.setSpacing(10);
    Scene scene = new Scene(hBox,300,200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Hello");
    primaryStage.show();

    textField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
          //Handle the change in the text value here
        }
    });
  }
}