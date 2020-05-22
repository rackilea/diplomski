public class JavaFXIcons extends Application {
@Override
public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

    Scene scene = new Scene(root);
    stage.getIcons().add(new Image(JavaFXIcons.class.getResourceAsStream("stackoverflow.jpg"))) ;
    stage.setScene(scene);
    stage.show();
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    launch(args);
  }
}