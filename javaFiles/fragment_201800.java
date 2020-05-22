public class MainController {
    private TopController topController;
    @FXML
    private Node mainPage;

    public void showPage() {
        mainPage.setVisible(true);
        mainPage.toFront();
    }

    public void hidePage() {
        mainPage.setVisible(false);
    }

    public void setTopController(TopController topController) {
        this.topController = topController;
    }

    @FXML
    public void toObjectPage() {
        topController.showObjectPage();
    }
}