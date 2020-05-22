public class KnopfController {

    private Controller mainController ;

    public void setMainController(Controller mainController) {
        this.mainController = mainController ;
    }

    // button handler:
    @FXML
    private void handleButtonClick(ActionEvent event) {
        mainController.textChange("Hello");
    }
}