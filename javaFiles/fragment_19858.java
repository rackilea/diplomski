public class FirstController implements Initializable {

  @FXML
  public void handleButtonAction(ActionEvent event) throws Exception{
    Node node = (Node) event.getSource();
    Stage stage = (Stage) node.getScene().getWindow();
    Scene scene = stage.getScene();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Second.fxml"));
    Parent root = (Parent) fxmlLoader.load();          

    scene.setRoot(root);
  }
}