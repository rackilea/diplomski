public class FXMLDocumentController {

    @FXML
    private Button button;
    @FXML
    private StackPane myStackPane;

    private Label label = new Label("Text 1");

    @FXML
    private void handleButtonAction(ActionEvent event) {

        FXMLLoader secondLoader = new FXMLLoader();
        secondLoader.setLocation(getClass().getResource("FXMLSecond.fxml"));

        try {
            secondLoader.load();
        } catch (IOException e) {e.printStackTrace();  }

        FXMLSecondController secondController = secondLoader.getController();
        secondController.setRefrences(myStackPane.getChildren(), label);

        Parent p = secondLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
    } 
}