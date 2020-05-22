public class FXMLSecondController {

    @FXML
    private Button saveText;
    @FXML
    private TextField textField;

    private ObservableList<Node> children;
    private Label label;

    @FXML
    private void saveTextBtnPressed(ActionEvent event) {

        label.setText(textField.getText());
        children.add(label);
        Stage stage = (Stage) saveText.getScene().getWindow();
        stage.close();
    }

    public void setRefrences(ObservableList<Node> children, Label label) {      
        this.children = children;
        this.label = label;
        textField.setText(label.getText());
    }
}