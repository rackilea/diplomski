public class KnopfController {

    private Model model ;

    public void setModel(Model model) {
        this.model = model ;
    }

    @FXML
    private void handleButton() {
        model.setText("Hello");
    }
}