public class FeldController {

    @FXML
    private TextField textField ;

    private Model model ;

    // ...
        textField.textProperty().bindBidirectional(model.textProperty());
    // ...
}