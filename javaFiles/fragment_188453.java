public class Controller {

    private Model model ;

    @FXML
    private FeldController feldController;

    @FXML
    private KnopfController knopfController;

    public void initialize() {
        model = new Model();
        knopfController.setModel(model);
        feldController.setModel(model);
    }
}