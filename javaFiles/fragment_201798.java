public class TopController implements Initializable {
    @FXML
    private MainController mainController;
    @FXML
    private ObjectController objectController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainController.setTopController(this);
        objectController.setTopController(this);
        showMainPage();
    }

    public void showMainPage() {
        objectController.hidePage();
        mainController.showPage();
    }

    public void showObjectPage() {
        mainController.hidePage();
        objectController.showPage();
    }
}