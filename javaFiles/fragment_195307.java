public class MyController implements Initializable {
    ...
    @FXML
    private Textfield textField;

    public void initialize() {
        ...
        textField.focusedProperty.addListener((ov, oldV, newV) -> {
           if (!newV) { // focus lost
              // Your code
           }
        });
         .....
    }
}