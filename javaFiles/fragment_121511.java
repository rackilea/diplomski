public class DialogController {

    // Ugh. DialogController cannot be used outside the context where
    // MainController exists.
    private MainController mainController ;

    @FXML
    private Button okButton ;

    public void setMainController(MainController mainController) {
        this.mainController = mainController ;
    }

    public void initialize() {
        okButton.setOnAction(e -> {
            if (mainController != null) {
                mainController.doSomething();
            }
        });
    }
}