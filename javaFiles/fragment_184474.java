public class Main extends Application {
  private static Stage pStage;

  // Creating a static root to pass to the controller
  private static BorderPane root = new BorderPane();


  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));

    AnchorPane screen1 = FXMLLoader.load(getClass().getResource("screen1.fxml"));

    root.setTop(main);
    root.setCenter(screen1);

    primaryStage.setTitle("Test FXML application");
    primaryStage.setScene(new Scene(root, 400, 400));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Just a root getter for the controller to use
   */
  public static BorderPane getRoot() {
    return root;
  }