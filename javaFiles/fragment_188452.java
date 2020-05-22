public class FeldController {

    @FXML
    private TextField textField ;

    private Model model ;

    public void setModel(Model model) {
        this.model = model ;
        textField.textProperty().bindBidirectional(model.textProperty());
    }
}