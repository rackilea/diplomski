public class Controller {
    @FXML
    private TextField textfield1;
    @FXML
    private TextField textfield2;

    @FXML
    public void initialize() {
        textfield1.focusedProperty().addListener((obs, oldValue, newValue) -> {
            if (!newValue) { // focus lost
                if (!"".equals(textfield1.getText())) {
                    textfield2.setText("blah, blah, blah");
                } else {
                    textfield2.setText("");
                }
            }
        });
    }
}