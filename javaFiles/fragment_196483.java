public class WelcomeController {

    @FXML
    private TextField textField ;

    @FXML
    private Button okButton ;

    @FXML
    public void okClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Person.fxml"));
        Parent root = loader.load();
        PersonController personController = loader.getController();
        personController.setName(textField.getText());
        okButton.getScene().setRoot(root);
    }
}