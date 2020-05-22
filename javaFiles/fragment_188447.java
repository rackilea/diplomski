public class Controller {

    @FXML
    private AnchorPane Main;

    @FXML
    private FeldController feldController;

    @FXML
    private KnopfController knopfController;

    public void initialize() {
        knopfController.setMainController(this);
    }

    public void textChange(String newText){
        feldController.updateText(newText);
    }
}