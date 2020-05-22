public class KnopfController {

    private Model model ;

    @FXML
    private void handleButton() {
        model.setText("Hello");
    }
}