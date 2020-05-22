public class MyEx2Controller implements Initializable {

@FXML
private Button btnUpdate;
@FXML
private TextField txtField;

@Override
public void initialize(URL url, ResourceBundle rb) {
}    

@FXML
private void doUpdateForTitle(ActionEvent event) {
    Test.getController().getLabel().setText(txtField.getText());
    Test.getStage2().close();
}

}