public class MainController {

    @FXML
    private DialogController dialogController ;

    public void initialize() {
        dialogController.setMainController(this);
    }

    public void doSomething() {
        // ...
    }
}