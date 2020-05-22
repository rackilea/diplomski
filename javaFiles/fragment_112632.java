public class FXMLSecondController implements Initializable {

    @FXML
    private Button saveText;
    @FXML
    private TextField textField;

    private StringProperty labelStringProperty;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textField.setEditable(true);
    }    

    @FXML
    private void saveTextBtnPressed(ActionEvent event) {

        /** By doing so you actually construct a new FXMLDocument
        FXMLLoader firstLoader = new FXMLLoader();
        firstLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));

        try {
            firstLoader.load();
        } catch (IOException e) {
        }

        FXMLDocumentController firstController = firstLoader.getController();
        firstController.putLabelOnStackPane(textField.getText());
        */
        labelStringProperty.set(textField.getText());
        Stage stage = (Stage) saveText.getScene().getWindow();
        stage.close();
    }

    /*
    public void setFieldText(String value) {
        textField.setText(value);
    }*/

    public void setTextProperty(StringProperty labelStringProperty) {
        this.labelStringProperty = labelStringProperty;
        textField.setText(labelStringProperty.get());
    }
}